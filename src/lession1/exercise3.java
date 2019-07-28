package lession1;

public class exercise3 {
    public static void main(String[] args) {
        // через дабл, чтоб не потерять внутренние результаты вычислений
        double a = 10;
        double b = 5;
        double c = 5;
        double d = 10;
        double operation = a * (b + (c / d));
        System.out.println(operation);
    }
}
