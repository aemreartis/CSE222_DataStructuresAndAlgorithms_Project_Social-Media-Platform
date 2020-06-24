public class Post {

    private String post;
    private Calendar postCalendar;
    private int postOwner;


    public Post(String post, Calendar postCalendar, int postOwner) {
        this.post = post;
        this.postCalendar = postCalendar;
        this.postOwner = postOwner;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Calendar getPostCalendar() {
        return postCalendar;
    }

    public void setPostCalendar(Calendar postCalendar) {
        this.postCalendar = postCalendar;
    }
}
