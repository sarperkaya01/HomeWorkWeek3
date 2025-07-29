package FindLetter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FindLetterApp {
    public static void main(String[] args) {
        ArrayList<String> harfler = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            char rastgeleHarf = (char) ('A' + (int) (Math.random() * 26));
            harfler.add(String.valueOf(rastgeleHarf));
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Bir harf giriniz :");

            String inputLetter = sc.next();
            if (inputLetter.length() < 2 && inputLetter.matches("[A-Z]")) {
                if (harfler.contains(inputLetter)) {
                    harfler.set(harfler.indexOf(inputLetter), MessageFormat.format("Found {0}", inputLetter));
                } else {
                    harfler.add(inputLetter);
                }
            } else {
                System.out.println("Lutfen yalnica 1 adet (buyuk) harf giriniz");
                i--;
            }


        }


        int maxLength = 0;

        for (String harf : harfler) {
            if (harf.length() > maxLength) {
                maxLength = harf.length();
            }
        }
        for (String harf : harfler) {
            System.out.printf("%-" + maxLength + "s ", harf);
        }


    }
}
