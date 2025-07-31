package MapEnrtyWrite;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapEnrtyWriteApp {
    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();

        scores.put("Ali", 85);

        scores.put("Ayşe", 92);

        scores.put("Mehmet", 78);

        scores.put("Zeynep", 90);

        scores.put("Burak", 88);


        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }




        // kodu okuyacak arkadaslar burasi kafanizi karistirmasin odevle alakasi yok

        /*for (String key : scores.keySet()) {
            int hash = key.hashCode();
            int bucket = (hash) & (16 - 1); // 16 = default initial capacity
            System.out.println(key + " -> hash: " + hash + ", bucket: " + bucket);
        }
        scores.put("FB", 78);
        scores.put("Ea", 100);*/
    }
}
