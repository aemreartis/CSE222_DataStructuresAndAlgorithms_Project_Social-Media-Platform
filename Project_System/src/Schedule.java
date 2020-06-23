import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;

public class Schedule{
    private ArrayList<Course> courses ;

    public Schedule() {
        this.courses = new ArrayList<Course>();
    }

    public boolean addCourse(Course courseList){ return false; }
    public boolean addCourses(ArrayList<Course> courseList){ return false; }

    public boolean removeCourse(Course course){return false;}

    public boolean removeCourses(Course course){return false;}


    public void clear() {
        courses.clear();
    }
}
