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
        System.out.println("Кот " + name + ", сыт? " + happiness + ", аппетит "+appetite);
    }
}

class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();
        cat.CatInfo();
        plate.putFood(10);
        plate.info();
    }
}