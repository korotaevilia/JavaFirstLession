package lession1;

public class exercise8 {
    public static void main(String[] args) {
        god(1200);
    }

    public static void god(int y) {
        if ((y % 4 == 0)&& (y % 400 == 0) && (y >0)){
            System.out.println("Високосный");}
            else if((y % 4 == 0) && (y % 100 == 0) && (y > 0)) {
                System.out.println("Не високосный сотый");}
            else if (y > 0){
                System.out.println("Не високосный");}
            else {
                System.out.println("Не правильный год");
        }

    }
}
//для пулл реквеста
