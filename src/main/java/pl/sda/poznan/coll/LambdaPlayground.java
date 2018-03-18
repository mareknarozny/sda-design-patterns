package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.List;

public class LambdaPlayground {
    public static void foo(Calc calc, int a, int b){
        System.out.println(calc.calculate(a,b));
    }
    public static void main(String[] args) {

        foo((a, b) -> a-b, 10, 3);



        Calc calc = (a, b) -> a+b;

        System.out.println(calc.calculate(5,2));
        System.out.println(calc.calculate(10,5));
        System.out.println(calc.calculate(15,20));

        Calc multiply  = (a,b)->a*b;
        System.out.println(multiply.calculate(2,4));

        List<Integer> lst = Arrays.asList(1,3,5,6,7,8,5);
        lst.stream().filter(x-> x>5);

        lst.forEach(x-> System.out.println(x));
        lst.forEach(System.out::println); //równoznaczne z tym co powyżej
    }
}
