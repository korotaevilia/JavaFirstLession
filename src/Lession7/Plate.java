package Lession7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else {
            return false;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
    public void putFood(int n){
        food+=n;
    }

    public int getFood() {
        return food;
    }
}

class Cat {
    private String name;
    private int appetite;
    boolean happiness = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        happiness = p.decreaseFood(appetite);
    }
    public void CatInfo(){
        System.out.println("Кот: " + name + ", сыт?: " + happiness + ", аппетит: "+appetite);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isHappiness() {
        return happiness;
    }
}

class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Василий", 5);
        Cat cat2 = new Cat("Мурзик",20);
        Cat cat3 = new Cat("Пушок",26);
        Cat[] arr = {cat1,cat2,cat3};
        Plate plate = new Plate(50);
        plate.info();
        for (int i =0 ; i< arr.length;i++){
            System.out.println("Котик "+arr[i].getName()+ " кушает из тарелки c аппетитом " +arr[i].getAppetite());
            arr[i].eat(plate);
            System.out.println("Удалось покушать? Котик счастлив? : " + arr[i].isHappiness());
            System.out.println("В тарелке осталось еды " + plate.getFood());
            System.out.println();
        }

    }
}