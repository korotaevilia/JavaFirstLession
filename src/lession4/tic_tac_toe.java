package lession4;

import java.util.Random;
import java.util.Scanner;

public class tic_tac_toe {


    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;
    static final int COUNT_OF_WIN = 4;

    static char[][] field = new char[SIZE_Y][SIZE_X];

    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '.';

    static Scanner scanner = new Scanner(System.in);
    static final Random rand = new Random();

    public static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void PrintField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    public static void playerStep() {
        int x, y;
        do {
            System.out.println("Введите координаты: X Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));

        setSym(y, x, PLAYER_DOT);
    }

    public static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean checkWin(char sym) {                                              // универсальная проверка,будет работать в любом поле с любым условием победы
        int countOfMatches = 0;
        for (int i = 0; i < SIZE_Y; i++) {                                                 //ищет по Х
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == sym) {
                    countOfMatches++;
                    if (countOfMatches == COUNT_OF_WIN) {
                        return true;
                    }
                } else {
                    countOfMatches = 0;
                }
            }
        }
        countOfMatches = 0;
        for (int j = 0; j < SIZE_X; j++) {                                                 //ищет по y
            for (int i = 0; i < SIZE_Y; i++) {
                if (field[i][j] == sym) {
                    countOfMatches++;
                    if (countOfMatches == COUNT_OF_WIN) {
                        return true;
                    }
                } else {
                    countOfMatches = 0;
                }
            }
        }
        countOfMatches = 0;
        for (int k = 0; k < SIZE_X * 2; k++) {                                       //ищет по диагонали снизу вверх
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < SIZE_X && j < SIZE_X) {
                    if (field[i][j] == sym) {
                        countOfMatches++;
                        if (countOfMatches == COUNT_OF_WIN) {
                            return true;
                        }
                    } else {
                        countOfMatches = 0;
                    }
                }
            }
        }
        countOfMatches = 0;
        for (int k = 0; k < SIZE_X * 2; k++) {                                       //ищет по диагонали сверху вниз
            for (int j = SIZE_X; j >= 0; j--) {
                int i = k - (SIZE_X-j);
                if (i < SIZE_X && j < SIZE_X && i>=0 && j>=0) {
                    if (field[i][j] == sym) {
                        countOfMatches++;
                        if (countOfMatches == COUNT_OF_WIN) {
                            return true;
                        }
                    } else {
                        countOfMatches = 0;
                    }
                }
            }
        }


        return false;
    }

    public static void aiStep() {
        int x, y;
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));

        setSym(y, x, AI_DOT);
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }

        return (field[y][x] == EMPTY_DOT);
    }

    public static void main(String[] args) {
        initField();
        PrintField();

        while (true) {
            playerStep();
            PrintField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Вы победили");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
            }
            aiStep();
            PrintField();
            if (checkWin(AI_DOT)) {
                System.out.println("Компьютер победил");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
            }
        }
        scanner.close();
    }

}


