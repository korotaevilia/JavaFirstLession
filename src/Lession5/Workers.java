package Lession5;

public class Workers {
    String fio;
    String functionality;
    String email;
    String phoneNumber;
    int salary;
    int age;


    public Workers(String fio, String functionality, String email, String phoneNumber, int salary, int age) {
        this.fio = fio;
        this.functionality = functionality;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void GetInfo() {
        System.out.println(fio + " " + functionality + " " + email + " " + phoneNumber + " " + salary + " ");
    }
}

class Main {
    public static void main(String[] args) {
        Workers[] workArray = new Workers[5];
        workArray[0] = new Workers("Иванов Иван Иванович", "Плотник", "ivan@gmail.com", "88005553535", 20000, 45);
        workArray[1] = new Workers("Петров Петр Петрович", "фрезировщик", "petr@mail.ru", "89992221212", 30000, 35);
        workArray[2] = new Workers("Сережина Инна Сергеевна", "прораб", "inna@gmail.com", "4242", 50000, 28);
        workArray[3] = new Workers("Натальева Наталья Кирилловна", "секретарь", "nata@gmail.com", "8282828", 30000, 41);
        workArray[4] = new Workers("Александров Александр Александрович","прораб","sansanych@mail.ru","88003555555",60000,48);
       for (int i = 0; i < workArray.length;i++){
           if (workArray[i].age > 40 ){
               workArray[i].GetInfo();
           }
       }
    }
}