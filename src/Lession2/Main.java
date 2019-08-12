package Lession2;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FirstExample(); //результаты
        System.out.println();
        SecondExample();
        System.out.println();
        ThirdExample();
        System.out.println();
        FourthExample();
        System.out.println();
        FifthExample();
        System.out.println();

        int[] sixthMass = {7, 2, 3, 1}; //для передачи в параметр 6го задания
        System.out.println(SixthExample(sixthMass));

        int seventhNum = 2;                                //пример с положительным числом
        int[] seventhMass = {1, 2, 3, 4, 5, 6, 7};
        SeventhExample(seventhNum, seventhMass);

        int seventhNum2 = -1;
        int[] seventhMass2 = {1, 2, 3, 4, 5, 6, 7};         //пример с отрицательным числом
        SeventhExample(seventhNum2, seventhMass2);

        EightExample();


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
                if (i == j) {                                     // сразу и заполняется массив и диагональный элемент = 1
                    mass[i][j] = 1;
                } else {
                    mass[i][j] = 0;
                }
                System.out.print(mass[i][j]);

            }

        }
    }

    //Пятое задание
    public static void FifthExample() {
        int[] mass = {1, 2, 3, 4, 5, 6, -20, 8, 9, 150, 11, 12};
        int max = mass[1];                                      //и максимальный и минимальный элементы принимаются за 1й эл. массива
        int min = mass[1];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > max) {
                max = mass[i];
            }
            if (mass[i] < min) {
                min = mass[i];
            }
        }
        System.out.println("min = " + min + " max= " + max);
    }

    //Шестое задание
    public static boolean SixthExample(int[] mass) {
        //   mass = {1, 2, 3, 6};
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < mass.length; i++) {         //левая сумма
            leftSum = leftSum + mass[i];
            rightSum = 0;
            for (int j = i + 1; j < mass.length; j++) {          // считаем для сравнения сумму после i элемента
                rightSum = rightSum + mass[j];
            }
            if (leftSum == rightSum) return true;
        }
        return false;                                   // если ничего не нашли
    }

    //Седьмое задание
    public static void SeventhExample(int n, int[] mass) {
        // 1 и 1,2,3,4,5,6,7
        if (n > 0) {
            for (int i = 0; i < n; i++) {                          //повтор сдвига на n элементов
                int cache = mass[mass.length - 1];                   //сохранение 1го элемента
                for (int j = (mass.length - 1); j > 0; j--) {
                    mass[j] = mass[j - 1];                              //сдвиг всех остальных на 1
                }
                mass[0] = cache;
            }
        } else if (n < 0) {
            for (int i = 0; i > n; i--) {
                int cache = mass[0];                                     //сохранение 1го элемента
                for (int j = 0; j < mass.length - 1; j++) {
                    mass[j] = mass[j + 1];                              //сдвиг всех остальных на 1
                }
                mass[mass.length - 1] = cache;
            }
        }
        System.out.println(Arrays.toString(mass));
    }


    //Дополнительное задание
    public static void EightExample() {
        int[] mass = {6, 5, 1, 3, 9};
        for (int i = mass.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mass[j] > mass[j + 1]) {
                    int buf = mass[j];                       //сохраняется в переменную , чтоб не затерся
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mass));
    }
}



