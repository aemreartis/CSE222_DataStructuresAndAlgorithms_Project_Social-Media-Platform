public class Music implements Comparable<Music> {
    String type;
    String name;
    String artist;
    String year;
    double rate;

    Music(String type, String name,String artist, String year, double rate){
        this.type = type;
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.rate = rate;
    }

    @Override
    public int compareTo(Music o) {
        return 0;
    }
}
