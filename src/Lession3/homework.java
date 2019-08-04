package Lession3;

import java.util.Random;
import java.util.Scanner;
// 2 задание.
public class homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        boolean repeat;
        do {                       // для перезапроса игры
            boolean answer = false;    //заготовка на цикл
            Random rand = new Random();
            int numOfword = rand.nextInt(words.length); //выбор слова для угадывания
            while (answer == false) {
                System.out.println("Угадай слово( англ, маленькие)");
                String inputWord = sc.nextLine();
                String preAnswer = "";
                for (int i = 0; i < words[numOfword].length() + 10; i++) {
                    if (i < inputWord.length() && i < words[numOfword].length()) {    //сравниваем буквы до конца загаданного слова
                        char a = inputWord.charAt(i);
                        char b = words[numOfword].charAt(i);
                        if (a == b) {
                            preAnswer = preAnswer + words[numOfword].charAt(i);     // если буквы одинаковые- заменяем в показанном ответе
                        } else {
                            preAnswer = preAnswer + "#";
                        }
                    } else if (i == words[numOfword].length()) {                   //  сравниваем 2 получившихся слова
                        if (preAnswer.equals(words[numOfword])) {
                            answer = true;
                            System.out.println("Угадал");
                            break;
                        }
                    } else {                                                        // добавляем символов до 10
                        preAnswer = preAnswer + "#";
                    }
                }
                System.out.println(preAnswer);

            }
            System.out.println("Продолжаем? да - дальше , остальное - заканчиваем");
            String next = sc.nextLine();
            if (next.equals("да")) {
                repeat = true;
            } else {
                repeat = false;}
        } while (repeat);
        sc.close();
    }
}