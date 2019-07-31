package Lession2;

import java.sql.Array;

public class Main {

    public static void main(String[] args) {
        FirstExample(); //результат для 1го задания
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


}