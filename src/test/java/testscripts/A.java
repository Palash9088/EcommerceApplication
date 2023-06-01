package testscripts;//import java.util.*;

public class A {
    void m1(String text) {
        int upperCase = 0, lowerCase = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 65 && c <= 90) {
                upperCase++;
                System.out.println(c + " is uppercase | count is " + upperCase);
            } else if (Character.isLowerCase(c)) {
                lowerCase++;
                System.out.println(c + " is LowerCase | count is " + lowerCase);
            }

        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.m1("Palash");
    }
}
