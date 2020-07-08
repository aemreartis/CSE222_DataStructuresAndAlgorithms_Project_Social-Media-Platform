import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class System implements SystemInterface{


    ArrayList<User> registeredUser;
    ArrayList<String> availableUser;
    SkipList<Music> musics;
    RedBlackTree<Movie> movies;
    AVLTree<Book> books;
    ArrayList<Admin> registeredAdmin;
    LinkedList<Club> clubs;
    ArrayList<Course> courses;
    ArrayList<Post> posts;
    Queue<Announcement> announcements;
    Queue<Event> events;


    public System() {
        this.clubs = new LinkedList<Club>();
        this.registeredUser = new ArrayList<>();
        this.availableUser = new ArrayList<>();
        this.registeredAdmin = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.musics = new SkipList<>();
        this.movies = new RedBlackTree<Movie>();
        this.books = new AVLTree<Book>();
        this.events = new LinkedList<>();
        this.announcements = new LinkedList<>();
        this.posts = new ArrayList<>();
    }

    // READ METHODS
    // When the system starts, all read methods run
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
            user.id = line.substring(1);
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
                    user.weeklySchedule.addCourse(line);
                }
                else if(line.charAt(0) == '#'){
                    user.myPosts.add(line);
                }
                else if(line.charAt(0) == '-'){
                    user.friendList.add(line.substring(1));
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
            this.registeredUser.add(user);
        }
    }

    public void readPosts() {

        File file = new File("src/Data/Post.txt");
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
            String userId = line.substring(1);

            Post post = new Post(postId, text, calender, userId);
            posts.add(post);
        }
    }

    public void readMovies() {
        File file = new File("src/Data/Movie.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){

            line = scanner.nextLine();
            String name = line;
            line = scanner.nextLine();
            String type = line;
            line = scanner.nextLine();
            String authorName = line;
            line = scanner.nextLine();
            String year = line;
            line = scanner.nextLine();
            double rate = Double.parseDouble(line);

            Movie movie = new Movie(type, name,authorName,year,rate);
            this.movies.add(movie);
        }
    }

    public void readBooks() {
        File file = new File("src/Data/Book.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){

            line = scanner.nextLine();
            String name = line;
            line = scanner.nextLine();
            String type = line;
            line = scanner.nextLine();
            String authorName = line;
            line = scanner.nextLine();
            String year = line;
            line = scanner.nextLine();
            double rate = Double.parseDouble(line);

            Book book = new Book(type, name,authorName,year,rate);
            this.books.add(book);
        }
    }

    public void readMusics() {
        File file = new File("src/Data/Music.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){

            line = scanner.nextLine();
            String type = line;
            line = scanner.nextLine();
            String name = line;
            line = scanner.nextLine();
            String authorName = line;
            line = scanner.nextLine();
            String year = line;
            line = scanner.nextLine();
            double rate = Double.parseDouble(line);

            Music music = new Music(type, name,authorName,year,rate);
            this.musics.add(music);
        }
    }

    public void readAvailableUser() {
        File file = new File("src/Data/AvailableUser.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){
            line = scanner.nextLine();
            String id = line;
            this.availableUser.add(id);
        }
    }

    public void readRegisteredAdmin(){
        File file = new File("src/Data/Admin.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){

            line = scanner.nextLine();
            String id = line.substring(1);
            line = scanner.nextLine();
            String name = line;
            line = scanner.nextLine();
            String password = line;
            line = scanner.nextLine();
            String mail = line;

            Admin admin = new Admin(id, name, password, mail);
            this.registeredAdmin.add(admin);
        }
    }

    public void readCourses() {
        File file = new File("src/Data/Course.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scanner.hasNext()){
            line = scanner.nextLine();
            String courseId = line;
            line = scanner.nextLine();
            String name = line;
            line = scanner.nextLine();
            String lecturer = line;
            line = scanner.nextLine();
            ArrayList<Course.Section> sections = new ArrayList<>();
            while(line.charAt(0) != '-'){
                String day = line;
                line = scanner.nextLine();
                String[] str1 = line.split(".");
                Time timeS = new Time(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]), Integer.parseInt(str1[2]));
                line = scanner.nextLine();
                String[] str2 = line.split(".");
                Time timeF = new Time(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]), Integer.parseInt(str2[2]));
                sections.add(new Course.Section(day,timeS,timeF));
                if (scanner.hasNext()){
                    line = scanner.nextLine();
                }
            }
            line = scanner.nextLine();
            ArrayList<String> students = new ArrayList<>();
            while(line.charAt(0) == '-'){
                students.add(line.substring(1));
                if (scanner.hasNext()){
                    line = scanner.nextLine();
                }
            }
            this.courses.add(new Course(courseId,name,lecturer,sections,students));
        }
    }

    public void readClubs() {

    }

    public void readEvents(){

    }

    public void readAnnouncements() {

    }



    // WRITE METHODS
    // When the system stops, all write methods run

    public void writeRegisteredUser() {

    }

    public void writePosts() throws IOException {
        FileWriter fileWriter = new FileWriter("src/Posts.txt",true);
        for (int i=0 ; i<posts.size() ; i++){
            fileWriter.write("\n" + posts.get(i).getPost());
            fileWriter.write("\n" + posts.get(i).getPostCalendar().date.day + "." +posts.get(i).getPostCalendar().date.month + "." + posts.get(i).getPostCalendar().date.year +" " +
                    posts.get(i).getPostCalendar().time.hour + "." + posts.get(i).getPostCalendar().time.minutes +":"+posts.get(i).getPostCalendar().time.second);
            fileWriter.write("\n" + posts.get(i).getPostOwner());
        }
        fileWriter.close();
    }

    public void writeEvents() throws IOException {
        FileWriter fileWriter = new FileWriter("src/Events.txt",true);
        for (int i=0 ; i<events.size() ; i++){
            Event temp = events.poll();
            fileWriter.write("\n" + temp.getId());
            fileWriter.write("\n" + temp.getName());
            fileWriter.write("\n" + temp.getDescription());
            fileWriter.write("\n" + temp.getDate().day +"."+ temp.getDate().month +"."+temp.getDate().year);
            fileWriter.write("\n" + temp.startTime.hour + "." + temp.startTime.minutes + ":" + temp.startTime.second);
            for(int j=0 ; j<temp.participants.size() ; j++){
                fileWriter.write("\n" + temp.participants.get(j));
            }
        }
        fileWriter.close();
    }

    @Override
    public void writeAnnouncements() throws IOException {
        FileWriter fileWriter = new FileWriter("src/announcements.txt",true);
        for (int i=0 ; i<announcements.size() ; i++){
            Announcement temp = announcements.poll();
            fileWriter.write("\n" + temp.title);
            fileWriter.write("\n" + temp.context);
            fileWriter.write("\n" + temp.date);
        }
        fileWriter.close();
    }
    // OPERATIONS METHODS

    // Uses for automaticly system operations
    public User loginUser(String id, String password){
        for (int i = 0; i < this.registeredUser.size(); i++){
            if (this.registeredUser.get(i).id.equals(id) && this.registeredUser.get(i).password.equals(password)){
                return registeredUser.get(i);
            }
        }
        return null;
    }
    public Admin loginAdmin(String id, String password){
        for (int i = 0; i < this.registeredAdmin.size(); i++){
            if (this.registeredAdmin.get(i).id.equals(id) && this.registeredAdmin.get(i).password.equals(password)){
                return registeredAdmin.get(i);
            }
        }
        return null;
    }
    public boolean signToSystem(String id, String username, String password, String name, String surname,
                                Date birthDate, String department, String email, String title){
        for (int i = 0; i < this.availableUser.size(); i++){
            if (this.availableUser.get(i).equals(id)){
                User user = new User( id,  username,  password,  name,  surname, birthDate,  department,  email,  title);
                this.registeredUser.add(user);
                return true;
            }
        }
        return false;
    }
    public boolean suggestion(){
        return false;
    }

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
