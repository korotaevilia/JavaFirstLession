package Lession2;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FirstExample(); //результат для 1го задания
        System.out.println();
        SecondExample();
        System.out.println();
        ThirdExample();
        System.out.println();
        FourthExample();

    }

    //Первое задание
    public static void FirstExample() {
        int[] mass = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1};
        for (int i : mass) {
            if (mass[i] == 1) {
                mass[i] = 0;
            } else {
                mass[i] = 1;
            }
            System.out.print(mass[i]);
        }
    }

    //Второе задание
    public static void SecondExample() {
        int[] mass = new int[8];
        for (int i = 0, ii = 0; (ii < 8); i += 3, ii = ii + 1) {   // i отвечает за сам элемент , ii за порядковый номер в массиве
            mass[ii] = i;
            System.out.print(mass[ii] + " ");


        }

    }

    //Третье задание
    public static void ThirdExample() {
        int[] mass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; (i < mass.length); i++) {
            if (mass[i] < 6) {
                mass[i] = mass[i] * 2;
            }
        }
        System.out.print(Arrays.toString(mass));
    }

    //Четвертое задание
    public static void FourthExample() {
        int[][] mass = new int[4][4];
        for (int i = 0; i < mass.length; i++) {
            System.out.println();
            for (int j = 0; j < mass[i].length; j++) {
                if (i == j) {
                    mass[i][j] = 1;
                } else {
                    mass[i][j] = 0;
                }
                System.out.print(mass[i][j]);

            }

        }
    }
}

