package Lession3;

import java.util.Random;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] words = {"персик","яблоко","мандарин","манго","вишня","лимон","абрикос","арбуз","дыня","апельсин","банан","слива","груша","малина","клубника"};
        boolean answer = false;    //заготовка на цикл
        Random rand = new Random();
        int numOfword = rand.nextInt(words.length); //выбор слова для угадывания
        int numberOftry = 0;
        StringBuilder preAnswer = new StringBuilder("");
        for (int i = 0; i < words[numOfword].length(); i++) {
            preAnswer = preAnswer.append('#');
        }

        while (answer == false) {
            System.out.println("Угадай слово( рус, маленькие) 5 попыток, по одной букве");
            String inputWord = sc.nextLine();
            boolean flag = false;


            for (int i = 0; i < words[numOfword].length(); i++) {
                if (i < words[numOfword].length()) {
                    char a = inputWord.charAt(0);
                    char b = words[numOfword].charAt(i);
                    if (a == b) {
                        preAnswer.deleteCharAt(i);
                        preAnswer.insert(i, words[numOfword].charAt(i));
                        flag = true;
                        if (preAnswer.toString().equals(words[numOfword])) {
                            answer = true;
                            System.out.println("Угадал");
                            break;
                        }
                    }

                }

            }
            System.out.println("попытка " + (numberOftry + 1));
            System.out.println("Слово " + preAnswer);

            if (flag == false) {
                numberOftry++;
            }
            if (numberOftry > 4) {
                System.out.println("Не Угадал");
                break;
            }


        }
        System.out.println("Ответ " + words[numOfword]);

    }
}

