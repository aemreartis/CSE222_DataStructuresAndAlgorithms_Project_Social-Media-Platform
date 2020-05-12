public class Admin {

    protected String name;
    protected String id;
    protected String password;
    protected String contact;

    public Admin(String name, String id, String password, String contact) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.contact = contact;
    }

    public boolean addAnnouncements() {
        return false;
    }

    public boolean removeRegisteredUser() {
        return false;
    }
}
