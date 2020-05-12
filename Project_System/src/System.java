import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class System implements SystemInterface{

    LinkedList<Club> clubs;
    ArrayList<User> registeredUser;
    ArrayList<ArrayList<Long>> availableUser;
    ArrayList<Admin> registeredAdmin;
    ArrayList<Course> courseList;
    ArrayList<Interest> interests;
    BinarySearchTree<Music> musics;
    BinarySearchTree<Movie> movies;
    BinarySearchTree<Book> books;
    PriorityQueue<Event> events;
    PriorityQueue<Announcement> announcements;

    // READ METHODS
    // When the system starts, all read methods run
    public boolean readMovies() {
        return false;
    }

    public boolean readBooks() {
        return false;
    }

    public boolean readMusics() {
        return false;
    }

    public boolean readAnnouncements() {
        return false;
    }

    public boolean readAvailableUser() {
        return false;
    }

    public boolean readRegisteredUser() {
        return false;
    }

    // WRITE METHODS
    // When the system stops, all write methods run
    public boolean writeMovies() {
        return false;
    }

    public boolean writeBooks() {
        return false;
    }

    public boolean writeMusics() {
        return false;
    }

    public boolean writeAnnouncements() {
        return false;
    }

    public boolean writeAvailableUser() {
        return false;
    }

    public boolean writeRegisteredUser() {
        return false;
    }

    // OPERATIONS METHODS
    // Uses for automaticly system operations
    public boolean loginToSystem(){
        return false;
    }
    public boolean signToSystem(){
        return false;
    }
    public boolean suggestion(){
        return false;
    }
}
