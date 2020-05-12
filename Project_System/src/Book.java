public class Book implements Comparable<Book> {
    String type;
    String name;
    String authorName;
    String year;
    double rate;

    Book(String type, String name,String authorName, String year, double rate){
        this.type = type;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.authorName = authorName;
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
