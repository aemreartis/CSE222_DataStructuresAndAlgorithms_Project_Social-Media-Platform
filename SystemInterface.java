public interface SystemInterface {

    boolean readMovies();
    boolean readBooks();
    boolean readMusics();
    boolean readAnnouncements();
    boolean readAvailableUser();
    boolean readRegisteredUser();

    boolean writeMovies();
    boolean writeBooks();
    boolean writeMusics();
    boolean writeAnnouncements();
    boolean writeAvailableUser();
    boolean writeRegisteredUser();

    boolean loginToSystem();
    boolean signToSystem();
    public boolean suggestion();
}
