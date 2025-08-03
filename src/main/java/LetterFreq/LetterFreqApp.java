package LetterFreq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LetterFreqApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bir kelime giriniz:");
        String word = sc.nextLine();
        //Map<Character,Integer> m = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char iChar = word.charAt(i);
            if (Character.isLetter(iChar)) {
                char key = Character.toLowerCase(iChar); // büyük/küçük farkını yok et
                m.put(key, m.getOrDefault(key, 0) + 1);
            }else{
                continue;
            }
        }
        System.out.println("Harf frekansları :");
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            System.out.printf("%c: %d%n", entry.getKey(), entry.getValue());
        }

    }
    public static Map<Character,Integer> m = new TreeMap<>();


}
