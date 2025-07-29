package FilmAndCollection;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Film {
    private String name;
    private int releaseDate;
    private String genre;
    private double IMDb;
    public String getName() {
        return name;
    }

    public Film(String name, int releaseDate, String genre, double IMDb) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.IMDb = IMDb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIMDb() {
        return IMDb;
    }

    public void setIMDb(double IMDb) {
        this.IMDb = IMDb;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseDate() {
        return releaseDate;
    }



    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }
    public static List<Film> ReturnGenre(Set<Film> films,String genre) {
        return films.stream()
                .filter(f -> f.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                ", IMDb=" + IMDb +
                '}';
    }

}
