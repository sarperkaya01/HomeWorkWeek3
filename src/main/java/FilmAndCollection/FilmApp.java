package FilmAndCollection;

import java.util.*;

public class FilmApp {
    public static void main(String[] args) {
        Comparator<Film> filmComparator = Comparator
                .comparingDouble(Film::getIMDb).reversed()                  // IMDb büyükten küçüğe
                .thenComparingInt(Film::getReleaseDate);                    // releaseDate küçükten büyüğe
        Set<Film> films = new TreeSet<>(filmComparator);


        films.add(new Film("Maymunlar Cehennemi", 2015,"Korku",3.1));
        films.add(new Film("Cehennem Maymunlari", 2016,"Aksiyon",6.2));
        films.add(new Film("Maymundaki  Cehennemler", 2017,"Komedi",6.9));
        films.add(new Film("Kizilcik Serbeti", 2018,"Komedi",9.8));
        films.add(new Film("Serbetci Kicilcik", 2016,"Korku",8.2));


        List<Film> byGenre =Film.ReturnGenre(films,"Komedi");
        byGenre.forEach(System.out::println);


    }

}
