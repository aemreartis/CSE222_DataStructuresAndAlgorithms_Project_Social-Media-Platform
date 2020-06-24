import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.*;

public class System implements SystemInterface{


    LinkedList<Club> clubs;
    ArrayList<User> registeredUser;
    ArrayList<Integer> availableUser;
    ArrayList<Admin> registeredAdmin;
    ArrayList<Course> courses;
    ArrayList<Post> posts;
    PriorityQueue<Announcement> announcements;
    PriorityQueue<Event> events;
    BinarySearchTree<Music> musics;
    BinarySearchTree<Movie> movies;
    BinarySearchTree<Book> books;


    public System() {
        this.clubs = new LinkedList<Club>();
        this.registeredUser = new ArrayList<>();
        this.availableUser = new ArrayList<>();
        this.registeredAdmin = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.musics = musics;
        this.movies = movies;
        this.books = books;
        this.events = new PriorityQueue<>();
        this.announcements = new PriorityQueue<>();
        this.posts = new ArrayList<>();
    }

    // READ METHODS
    // When the system starts, all read methods run
    public void readMovies() {

    }

    public void readBooks() {

    }

    public void readMusics() {

    }

    public void readAnnouncements() {

    }

    public void readAvailableUser() {

    }

    public void readClubs() {

    }

    public void readCourses() {

    }

    public void readEvents(){

    }

    public void readRegisteredAdmin(){

    }

    public void readRegisteredUser() {
        File folder = new File("src/Data/Users");
        ArrayList<String> files = filesInFolder(folder);
        for (int i = 0; i < files.size(); i++) {
            File file = new File("\\"+files.get(i));
            User user = new User();
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String line = scanner.nextLine();
            user.id = Integer.parseInt(line);
            line = scanner.nextLine();
            user.username = line;
            line = scanner.nextLine();
            user.password = line;
            line = scanner.nextLine();
            user.name = line;
            line = scanner.nextLine();
            user.surname = line;
            line = scanner.nextLine();
            String[] date = line.split(".");
            user.birthDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            line = scanner.nextLine();
            user.department = line;
            line = scanner.nextLine();
            user.email = line;
            line = scanner.nextLine();
            user.title = line;

            while(scanner.hasNext()){
                line = scanner.nextLine();

                if (line.charAt(0) == '*'){
                    user.myCourse.add(line);
                }
                else if(line.charAt(0) == '#'){
                    user.myPosts.offer(line);
                }
                else if(line.charAt(0) == '-'){
                    user.friendList.add(Integer.parseInt(line));
                }
                else if(line.charAt(0) == '+'){
                    user.movies.add(line);
                }
                else if(line.charAt(0) == '&'){
                    user.books.add(line);
                }
                else if(line.charAt(0) == '%'){
                    user.musics.add(line);
                }
            }
        }
    }

    public void readPosts() {

        File file = new File("src/Data/Posts.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){
            line = scanner.nextLine();
            String postId = line;
            line = scanner.nextLine();
            String text = line;
            line = scanner.nextLine();
            String[] str1 = line.split(".");
            Date date = new Date(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]), Integer.parseInt(str1[2]));
            line = scanner.nextLine();
            String[] str2 = line.split(".");
            Time time = new Time(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]), Integer.parseInt(str2[2]));
            Calendar calender = new Calendar(date,time);
            line = scanner.nextLine();
            int userId = Integer.parseInt(line);

            Post post = new Post(postId, text, calender, userId);
            posts.add(post);
        }
    }


    // WRITE METHODS
    // When the system stops, all write methods run
    public void writeMovies() {

    }

    public void writeBooks() {

    }

    public void writeMusics() {

    }

    public void writeAnnouncements() {

    }

    public void writeRegisteredUser() {

    }

    public void writeRegisteredAdmin() {

    }

    public void writePosts(){

    }

    public void writeClubs() {

    }

    public void writeCourses() {

    }

    public void writeEvents(){

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

    //
    public ArrayList<String> filesInFolder(File folder) {
        ArrayList<String> files = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                filesInFolder(fileEntry);
            }else {
                files.add(fileEntry.getName());
            }
        }
        return files;
    }
}
