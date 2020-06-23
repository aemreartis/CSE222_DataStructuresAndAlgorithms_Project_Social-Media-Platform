import java.util.ArrayList;

public class Schedule{
    private ArrayList<Course> courses ;

    public Schedule() {
        this.courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean addCourse(Course courseList){
        boolean res = courses.add(courseList);
        return res;
    }
    public boolean addCourses(ArrayList<Course> courseList){
        for(int i=0;i<courseList.size();i++){
            courses.add(courseList.get(i));
        }
        return true;
    }

    public boolean removeCourse(Course course){
        boolean res =  courses.remove(course);
        return res;
    }

    public boolean removeCourses(ArrayList<Course> courseList){
        for(int i=0;i<courseList.size();i++){
            courses.remove(courseList.get(i));
        }
        return true;
    }

    public void clear() {
        courses.clear();
    }
}