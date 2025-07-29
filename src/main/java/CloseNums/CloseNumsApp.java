package CloseNums;

import com.sun.source.tree.Tree;


import java.util.*;

public class CloseNumsApp {
    public static void main(String[] args) {
        List<Integer> closeNum = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int iter = 1;
        while (true) {
            if (iter > 10)
                break;
            System.out.println((iter) + ". pozitif tam sayiyi giriniz:");

            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                if (num > 0) {

                    boolean added = closeNum.add(num);

                    if (added) {
                        iter++;

                    } else {
                        System.out.println("Girdiginiz sayi arrayde bulunmaktadir");
                    }


                } else {
                    System.out.println("Lutfen pozitif bir tamssayi giriniz.");

                }

            } else {
                System.out.println("Lutfen integer bir sayi giriniz.");
                sc.next();
            }
        }


        closeNum.sort((a, b) -> a - b);
        List<Integer> diffs = new ArrayList<>();
        for (int i = 1; i < closeNum.size(); i++) {
            int prev = closeNum.get(i - 1);
            int curr = closeNum.get(i);
            int diff = curr - prev;

            diffs.add(diff);

        }
        boolean allSame = diffs.stream().distinct().count() == 1;
        if (allSame) {
            System.out.println("Tum sayilar arasindaki fark aynidir.");
        } else {
            int minValue = Collections.min(diffs);
            List<Integer> minIndexes = new ArrayList<>();
            for (int i = 0; i < diffs.size(); i++) {
                if (diffs.get(i) == minValue) {
                    minIndexes.add(i);
                }
            }
            System.out.println("Listedeki en küçük fark: " + minValue);
            if (minIndexes.size() > 1) {

                System.out.println("Bu değerden " + minIndexes.size() + " tane var.");
                System.out.println("Birbirine en yakin sayilar: ");
                for (int i = 0; i < minIndexes.size(); i++) {

                    System.out.println(closeNum.get(minIndexes.get(i)) + " ve " +
                            closeNum.get(minIndexes.get(i) + 1) );

                }
            }else{
                System.out.println("Birbirine en yakin sayilar: ");
                System.out.println(closeNum.get(minIndexes.get(0)) + " ve " +
                        closeNum.get(minIndexes.get(0) + 1) );
            }

        }


    }
}
