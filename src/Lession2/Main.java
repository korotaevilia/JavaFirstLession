package Lession2;

import java.sql.Array;

public class Main {

    public static void main(String[] args) {
        FirstExample(); //результат для 1го задания
        System.out.println();
        SecondExample();

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


}