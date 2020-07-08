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

    boolean loginToSystem();
    boolean signToSystem();
    public boolean suggestion();
}
