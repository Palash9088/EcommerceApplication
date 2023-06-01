package test;//import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Demo {

    void secondHighest(int[] arr) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num != highest) {
                secondHighest = num;
            }
        }
        System.out.println("Highest is : " + highest);
        System.out.println("Second Highest is : " + secondHighest);
    }

    void secondHighest(ArrayList<Integer> tempList){
        Collections.sort(tempList);
        var i = tempList.get(tempList.size()-2);
        System.out.println(i);
    }

    public static void main(String[] args) {
        int[] arr = {60,70,10,20,30,40,50};
        Demo demo = new Demo();
        demo.secondHighest(arr);
        ArrayList <Integer> arrayList = new ArrayList<>(Arrays.asList(60,70,10,20,30,40,50));
        demo.secondHighest(arrayList);
    }
}
