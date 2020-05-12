public class Movie implements Comparable<Movie> {
    String type;
    String name;
    String directorName;
    String year;
    double rate;

    Movie(String type, String name,String directorName, String year, double rate){
        this.type = type;
        this.name = name;
        this.directorName = directorName;
        this.year = year;
        this.rate = rate;
    }

    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
