public class Admin {

    protected System access;
    protected String name;
    protected String id;
    protected String password;
    protected String mail;

    public Admin( String id, String name, String password, String mail) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.mail = mail;
    }

    public boolean addAnnouncements(String tittle, String announcements,String date) {
        access.announcements.add(new Announcement(tittle,announcements,date));
        return true;
    }

    public boolean removeRegisteredUser(String id) {
        for (int i = 0; i < access.registeredUser.size();i++){
            if (access.registeredUser.get(i).id.equals(id)){
                access.registeredUser.remove(i);
                return true;
            }
        }
        return false;
    }
}
