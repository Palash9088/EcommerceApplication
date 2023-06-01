package test;//import java.util.*;

public class SumEven {

    //Write a Java program to find the sum of all even numbers between 1 and 100.
    boolean isEven(int num) {
        boolean flag = false;
        if (num % 2 == 0) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        SumEven sumEven = new SumEven();
        int sum =0;
        for(int i=1;i<=100;i++)
        {
            if(sumEven.isEven(i) == true){
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

}
