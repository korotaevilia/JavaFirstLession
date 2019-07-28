package lession1;

public class exercise3 {
    public static void main(String[] args) {
        System.out.println(result(1,2,3,4));
    }

    public static double result(double a,double b,double c, double d)
        {
            // через дабл, чтоб не потерять внутренние результаты вычислений
            double operation = a * (b + (c / d));
            return operation;
         }}
