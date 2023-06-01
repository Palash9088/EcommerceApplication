package test;//import java.util.*;

import java.util.ArrayList;

public class CharCountCollections {
    void countChar(String word, char ch) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add(word);
        int count = 0;
        for (int i = 0; i < wordList.get(0).length(); i++) {

            if (wordList.get(0).charAt(i) == ch) {
                count++;
            }
        }
        System.out.println("Count of " + ch + " is " + count);
    }

    public static void main(String[] args) {
        CharCountCollections c = new CharCountCollections();
        c.countChar("Palash", 'a');
    }
}
