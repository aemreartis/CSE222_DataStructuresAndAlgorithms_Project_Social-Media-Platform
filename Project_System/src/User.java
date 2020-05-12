public class User {
    //User Informations
    System access;
    int id ;
    String username;
    String password;
    String name;
    String surname;
    Date birthDate;
    String Department;
    String email;
    String title;

    Schedule weeklySchedule;

    Queue<Post> posts;
    Queue<Post> myPosts;

    //Hobbies
    LinkedList<Movie> movies;
    LinkedList<Music> musics;
    LinkedList<Book> books;

    ArrayList<Interest> myInterests; // ???


    //FriendList (and Interaction data if needed any)
    ArrayList<User> friendList;//Students, Groups and Lecturers


    List<Event> friendEvents;


    //Other System Variables
    BinarySearchTree<Event> events;//???
    Queue<Notification> notifications; //Or stack



    //User Information Methods
    public boolean editUsername(String username);
    public boolean editPassword(String password);
    public boolean editName(String name);
    public boolean editSurname(String surname);
    public boolean editBirthDate(Date birthDate);
    public String editDepartment();
    public String editEmail();
    public String editTitle();
    
    public String getName();
    public String getSurname();
    public String getTitle();
    public Date getBirthDate();
    public String getDepartment();
    public String getEmail();
    public String getTitle();
        
    public Schedule getSchedule();


    //Schedule editting
    public boolean addCourse(Course course);//Parameter may be course id.
    public Course removeCourse(Course course)
    public void clearSchedule();


    //Friend Interactions
    public boolean addFriend(User newFriend);
    public boolean removeFriend(int friendId);//Parameter? Friend
    public User getFriend(int friendId);
    public List<User> getFriendList();

    public Schedule compareSchedule(Schedule friendSchedule);


    //Event Interactions
    public boolean addEvent(Event event);
    public ArrayList<TimeFrame> findTimeFrames();

    public boolean removeEvent(Event event);

    public Event getEvent(int eventId)

    public BinarySearchTree<Event> getEvents();

    public List<Event> getFriendEvents();//




    //Other System Interactions
    public Queue<Notification> getNotifications();
    public boolean removeNotification();
    public boolean addPost();
    public boolean deletePost();
    
    public void removeMyProfile();


}
