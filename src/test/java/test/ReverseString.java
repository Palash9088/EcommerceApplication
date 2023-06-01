package test;//import java.util.*;

public class ReverseString {

    /*
        String input  = “P*la&h”  h*al&P
        h*al&P  h&al&P   h*al*P
     */
    void revString(String input) {
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--){
            rev = rev + input.charAt(i);
        }
        //System.out.print(rev);
    }
    void revString1(String word){

    }
    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        r.revString("P*la&h");

        String inputString = "P*la&h";
        String[] specialChars = inputString.split("[a-zA-Z0-9]+");
        String alphaNumericString = inputString.replaceAll("[^a-zA-Z0-9]", "");
        String reversedString = new StringBuilder(alphaNumericString).reverse().toString();
        StringBuilder outputStringBuilder = new StringBuilder(reversedString);

        for (String specialChar : specialChars) {
            int index = inputString.indexOf(specialChar);
            outputStringBuilder.insert(index, specialChar);
        }

        String outputString = outputStringBuilder.toString();
        System.out.println(outputString);  // Output: h*al&P
    }

}

