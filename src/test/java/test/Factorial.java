package test;//import java.util.*;

public class Factorial {

    void factorialNumber(int num){

        int fact =1;
        for(int i=1;i<=num;i++){
            fact = fact * i;
        }
        System.out.println(fact);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        factorial.factorialNumber(5);
    }
}
