package Lession8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private static final char PLAYER_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';
    private static final int DELTA_DRAW = 10;
    private static Random random = new Random();
    private GameOverWindow gameOverWindow;

    char[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLenght;
    boolean gameOver;
    boolean isWait;
    int mode;
    int cellHeight;
    int cellWidth;
    boolean isInitialized = false;
    boolean stepPlayer2;

    Map() {
        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        gameOverWindow = new GameOverWindow();
    }

    // ход игрока, попытался прикрутить возможность логики для проверки валидности хода( чтоб ход не шел пока не  поставишь Х в пустую)
    void playerStep(int y, int x, char symbol) {
        setSym(y, x, symbol);
    }

    void aiStep() {
        //проверка победы ИИ
        for (int i = 0; i < fieldSizeY; i++)
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, AI_DOT);
                    if (checkWin(AI_DOT)) return;
                    setSym(i, j, EMPTY_DOT);
                }
            }
        //Проверка победы игрока
        for (int i = 0; i < fieldSizeY; i++)
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, PLAYER_DOT);
                    if (checkWin(PLAYER_DOT)) {
                        setSym(i, j, AI_DOT);
                        return;
                    }
                    setSym(i, j, EMPTY_DOT);
                }
            }
        //Если выигрышного нет, то ходим рандомом
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellValid(y, x));
        setSym(y, x, AI_DOT);
    }

    //запуск хода при клике мышкой, прикрутил мессадж при ходе в "Занятую" ячейку
    void update(MouseEvent e) {
        if (!gameOver && !isWait) {
            int cellX = e.getX() / cellWidth;
            int cellY = e.getY() / cellHeight;
            if (field[cellY][cellX] == EMPTY_DOT) {
                if (mode == 0) modePlayAI(cellY, cellX);
                else modeTwoPlayer(cellY, cellX);
            } else {gameOverWindow.setMessageWrong("Нельзя ходить в занятую ячейку");}
        }
    }

    // Режим двух игроков
    void modeTwoPlayer(int y, int x) {
        char symbol = stepPlayer2 ? AI_DOT : PLAYER_DOT;
        playerStep(y, x, symbol);
        repaint();
        if (checkWin(symbol)) {
            gameOverWindow.setMessage(stepPlayer2 ? "Победа второго игрока" : "Первый игрок победил", this);
            return;
        }
        if (isFuelFull()) {
            gameOverWindow.setMessage("Ничья", this);
            return;
        }
        //решение на 10/10 ))
        stepPlayer2 = !stepPlayer2;
    }

    // Режим против компьютера, по сути вся игра описана тут
    void modePlayAI(int y, int x) {
        playerStep(y, x, PLAYER_DOT);
        repaint();
        if (checkWin(PLAYER_DOT)) {
            gameOverWindow.setMessage("Игрок победил", this);
            return;
        }
        if (isFuelFull()) {
            gameOverWindow.setMessage("Ничья", this);
            return;
        }
        isWait = true;
        aiStep();
        isWait = false;
        repaint();
        if (checkWin(AI_DOT)) {
            gameOverWindow.setMessage("ИИ победил", this);
            return;
        }
        if (isFuelFull()) {
            gameOverWindow.setMessage("Ничья", this);
            return;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    // старт игры с указанными параметрами
    void startNewGame(int mode, int filedSizeX, int filedSizeY, int winLen) {
        System.out.println(mode + " " + filedSizeX + " " + winLen);
        gameOver = false;
        stepPlayer2 = false;
        isWait = false;
        this.fieldSizeX = filedSizeX;
        this.fieldSizeY = filedSizeY;
        this.winLenght = winLen;
        this.mode = mode;
        field = new char[filedSizeY][filedSizeX];
        initFields();
        isInitialized = true;
        repaint();
    }

    //полная перерисовка поля.
    void render(Graphics g) {
        if (!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        cellWidth = panelWidth / fieldSizeY;
        cellHeight = panelHeight / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[j][i] != EMPTY_DOT) {
                    if (field[j][i] == PLAYER_DOT) {
                        // Рисуем Х
                        g.drawLine((i * cellWidth) + DELTA_DRAW, (j * cellHeight) + DELTA_DRAW, (i + 1) * cellWidth - DELTA_DRAW, (j + 1) * cellHeight - DELTA_DRAW);
                        g.drawLine((i + 1) * cellWidth - DELTA_DRAW, (j * cellHeight) + DELTA_DRAW, (i * cellWidth) + DELTA_DRAW, (j + 1) * cellHeight - DELTA_DRAW);
                    }
                    if (field[j][i] == AI_DOT) {
                        // Рисуем О
                        g.drawOval((i * cellWidth) + DELTA_DRAW, (j * cellHeight) + DELTA_DRAW, cellWidth - DELTA_DRAW * 2, cellHeight - DELTA_DRAW * 2);
                    }
                }
            }
        }
    }

    //начальное заполнение пустыми элементами массива хранящего поля
    private void initFields() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    //установка символа
    private void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    // проверка линии по 4м направлениям
    private boolean checkLine(int y, int x, int vy, int vx, char sym) {
        int wayX = x + (winLenght - 1) * vx;
        int wayY = y + (winLenght - 1) * vy;
        if (wayX < 0 || wayY < 0 || wayX > fieldSizeX - 1 || wayY > fieldSizeY - 1) return false;
        for (int i = 0; i < winLenght; i++) {
            int itemY = y + i * vy;
            int itemX = x + i * vx;
            if (field[itemY][itemX] != sym) return false;
        }
        return true;
    }

    // собственно проверка самой победы
    private boolean checkWin(char sym) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (checkLine(i, j, 0, 1, sym)) return true;   // проверим линию по х
                if (checkLine(i, j, 1, 1, sym)) return true;   // проверим по диагонали х у
                if (checkLine(i, j, 1, 0, sym)) return true;   // проверим линию по у
                if (checkLine(i, j, -1, 1, sym)) return true;  // проверим по диагонали х -у
            }
        }
        return false;
    }

    //проверка ничьи
    boolean isFuelFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // проверка ячейки на существование в поле
    boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > fieldSizeX - 1 || y > fieldSizeY - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }
}