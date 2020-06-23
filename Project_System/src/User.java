import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
    //User Informations
    System access;
    int id ;
    String username;
    String password;
    String name;
    String surname;
    Date birthDate;
    String department;
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
    List<Event> events;//???
    Queue<Notification> notifications; //Or stack


    //User Information Methods
    public boolean editUsername(String username) {
        this.username= username;
        java.lang.System.out.println("Username editted succesfully.");
        return true;
    }

    public boolean editPassword(String password) {
        this.password= password;
        java.lang.System.out.println("Password editted succesfully.");
        return true;
    }

    public boolean editName(String name) {
        this.name=name;
        java.lang.System.out.println("Name editted succesfully.");
        return true;
    }

    public boolean editSurname(String surname) {
        this.surname=surname;
        java.lang.System.out.println("Surname editted succesfully.");
        return true;
    }


    public boolean editBirthDate(int day,int month,int year) {//parametreler stringe dönüştürebiliriz
        Date newDate=new Date(day,month,year);
        this.birthDate=newDate;
        java.lang.System.out.println("Birth date editted succesfully.");
        return true;
    }

    public boolean editDepartment(String department) {
        this.department = department;
        return true;
    }

    public boolean editEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean editTitle(String title) {
        this.title = title;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTitle() {
        return title;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }


    public Schedule getSchedule() {
        return weeklySchedule;
    }


    //Schedule editting
    public boolean addCourse(Course course){
        return weeklySchedule.addCourse(course);
    }

    public boolean removeCourse(Course course) {
        return weeklySchedule.removeCourse(course);
    }

    public void clearSchedule() {
        weeklySchedule.clear();
    }


    //Friend Interactions
    public boolean addFriend(User newFriend) {
        friendList.add(newFriend);
        return false;
    }

    public boolean removeFriend(int friendId){

        friendList.remove(friendId);
        return true;
    }

    public User getFriend(int friendId) {
        return friendList.get(friendId);
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public Schedule compareSchedule(Schedule friendSchedule) {
        return null;
    }

    public ArrayList<TimeFrame> findTimeFrames() {
        return null;
    }


    //Event Interactions
    public boolean addEvent(Event event) {
        return events.add(event);
    }


    public boolean removeEvent(Event event){
        return events.remove(event);
    }

    public Event getEvent(int eventId){
        return events.get(eventId);
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> getFriendEvents(){
        return friendEvents;
    }


    //Other System Interactions
    public Queue<Notification> getNotifications() {
        return notifications;
    }

    public boolean removeNotification(int notifyId) {
        return notifications.remove(notifyId);
    }

    public boolean addPost(String postContent) {
        Post newPost=new Post(postContent, new Calendar(), this);
        return posts.add(newPost);
    }

    public boolean deletePost(int postId) {
        return posts.remove(postId);
    }

    public void removeMyProfile() {

    }


}
