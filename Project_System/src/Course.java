import java.util.ArrayList;

public class Course {
    public static class Section{
        String day;
        Time startTime;
        Time finishTime;


        public Section(String day, Time startTime, Time finishTime) {
            this.day = day;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }
    }

    String id;
    String name;
    String lecturer;
    ArrayList<Section> sections;
    ArrayList<User> students;

    public Course(String id, String name, String lecturer, ArrayList<Section> sections) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.sections = sections;
    }
}
