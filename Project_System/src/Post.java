public class Post {

    private String postId;
    private String post;
    private Calendar postCalendar;
    private String postOwner;


    public Post(String postId, String post, Calendar postCalendar, String postOwner) {
        this.postId = postId;
        this.post = post;
        this.postCalendar = postCalendar;
        this.postOwner = postOwner;
    }

    public String getPost() {
        return post;
    }

    public String getPostId() {
        return postId;
    }

    public String getPostOwner() {
        return postOwner;
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
                ", postOwner='" + postOwner + '\'' +
                '}';
    }
}
