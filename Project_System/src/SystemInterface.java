public interface SystemInterface {

    void readMovies();
    void readBooks();
    void readMusics();
    void readAnnouncements();
    void readAvailableUser();
    void readRegisteredUser();
    void readPosts();
    void readCourses();
    void readClubs();
    void readEvents();
    void readRegisteredAdmin();

    void writeMovies();
    void writeBooks();
    void writeMusics();
    void writeAnnouncements() throws IOException;
    void writeRegisteredUser();
    void writeRegisteredAdmin();
    void writePosts();
    void writeClubs();
    void writeCourses();
    void writeEvents();

    User loginUser(String id, String password);
    Admin loginAdmin(String id, String password);
    boolean signToSystem(String id, String username, String password, String name, String surname,
                                Date birthDate, String department, String email, String title);
    public boolean suggestion();
}
