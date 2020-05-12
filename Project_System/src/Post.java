public class Post {

    private String post;
    private Calendar postCalendar;
    private User postOwner;


    public Post(String post, Calendar postCalendar, User postOwner) {
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


    @Override
    public String toString() {
        return "Post{" +
                "post='" + post + '\'' +
                ", postCalendar=" + postCalendar +
                ", postOwner='" + postOwner.name + '\'' +
                '}';
    }
}
