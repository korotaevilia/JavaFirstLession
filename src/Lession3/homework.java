package Lession3;

import java.util.Random;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        boolean answer = false;    //заготовка на цикл
        Random rand = new Random();
        int numOfword = rand.nextInt(words.length); //выбор слова для угадывания
        int numberOftry = 0;
        StringBuilder preAnswer = new StringBuilder("");
        for (int i = 0; i < words[numOfword].length(); i++) {
            preAnswer = preAnswer.append('#');
        }
        while (answer == false) {
            System.out.println("Угадай слово( англ, маленькие) 10 попыток, по одной букве");
            String inputWord = sc.nextLine();

            for (int i = 0; i < words[numOfword].length(); i++) {
                if (i < words[numOfword].length()) {
                    char a = inputWord.charAt(0);
                    char b = words[numOfword].charAt(i);
                    if (a == b) {
                        preAnswer.deleteCharAt(i);
                        preAnswer.insert(i, words[numOfword].charAt(i));
                        if (preAnswer.toString().equals(words[numOfword])) {
                            answer = true;
                            System.out.println("Угадал");
                            break;
                        }
                    }

                }

            }
            System.out.println("попытка " + (numberOftry + 1));
            System.out.println("Ответ " + preAnswer);
            numberOftry++;
            if (numberOftry > 9) {
                System.out.println("Не Угадал");
                break;
            }

        }
        System.out.println(preAnswer);

    }
}

