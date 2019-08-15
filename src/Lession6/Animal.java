package Lession6;


import java.util.Random;

public abstract class Animal {
    String name;

    public abstract void Run(int distance);

    public abstract void Jump(double height);

    public abstract void Swim(double swimDistance);

    public Animal(String name) {
        this.name = name;
    }

    public void Success() {
        System.out.println(name + " Успешно преодолел дистанцию");
    }

    public void Faulire() {
        System.out.println(name + " Не смог преодолеть дистанцию");
    }
}

class Cat extends Animal {

    int staminaRun;
    final int STAMINA_RUN = 200;

    @Override
    public void Run(int distance) {
        if (staminaRun >= distance) {
            Success();
        } else {
            Faulire();
        }
    }

    double heightJump;
    final int HEIGHT_JUMP =2;

    @Override
    public void Jump(double height) {
        if (heightJump >= height)
            Success();
        else
            Faulire();
    }

    @Override
    public void Swim(double swimDistance) {
        Faulire();
    }

    public void CatInfo() {
        System.out.println("Кот " + name);
        System.out.println("Бег (м) = " + staminaRun);
        System.out.println("Прыжок (м) = " + heightJump);
        System.out.println("Кот " + name + " не плавает");
    }

    public Cat(String name) {
        super(name);
        Random random = new Random();
        this.staminaRun = STAMINA_RUN + random.nextInt(100);    // + 0-100 к дальности
        this.heightJump = HEIGHT_JUMP + random.nextDouble();
    }

}

class Dog extends Animal {                                   // сделал рандом только для собак)

    int staminaRun;
    final int STAMINA_RUN = 500;

    @Override
    public void Run(int distance) {
        if (staminaRun >= distance) {
            Success();
        } else {
            Faulire();
        }
    }

    double heightJump;
    final double HEIGHT_JUMP = 0.5;

    @Override
    public void Jump(double height) {
        if (heightJump >= height) {
            Success();
        } else {
            Faulire();
        }
    }

    double staminaSwim;
    final double STAMINA_SWIM = 10;

    @Override
    public void Swim(double swimDistance) {
        if (staminaSwim >= swimDistance) {
            Success();
        } else {
            Faulire();
        }
    }

    public void DogInfo() {
        System.out.println("Пес " + name);
        System.out.println("Бег (м) = " + staminaRun);
        System.out.println("Прыжок (м) = " + heightJump);
        System.out.println("Плавать (м) = " + staminaSwim);
    }


    public Dog(String name) {
        super(name);
        Random random = new Random();
        this.staminaRun = STAMINA_RUN + random.nextInt(100);    // + 0-100 к дальности
        this.heightJump = HEIGHT_JUMP + random.nextDouble();            //+ 0-1 к прыжку
        this.staminaSwim = STAMINA_SWIM + random.nextDouble()*5;        //+ 0-5 к заплыву
    }
}

class MainOlympics {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик");
        cat1.CatInfo();
        System.out.println();
        Dog dog1 = new Dog("Шарик");
        dog1.DogInfo();
        System.out.println();
        System.out.println("Забег");
        System.out.println();
        dog1.Run(11);
        cat1.Run(21);
        System.out.println();
        System.out.println("Заплыв");
        dog1.Swim(12);
        cat1.Swim(11);
        System.out.println();
        System.out.println("Прыжок");
        dog1.Jump(0.1);
        cat1.Jump(3.1);


    }
}
