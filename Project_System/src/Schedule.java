import java.util.ArrayList;

public class Schedule{
    private ArrayList<String> courses ;

    public Schedule() {
        this.courses = new ArrayList<String>();
    }

    public ArrayList<String> getCourses() {

        return courses;
    }

    public boolean addCourse(String courseList){
        boolean res = courses.add(courseList);
        return res;
    }
    public boolean addCourses(ArrayList<String> courseList){
        for(int i=0;i<courseList.size();i++){
            courses.add(courseList.get(i));
        }
        return true;
    }

    public boolean removeCourse(String course){
        boolean res =  courses.remove(course);
        return res;
    }

    public boolean removeCourses(ArrayList<String> courseList){
        for(int i=0;i<courseList.size();i++){
            courses.remove(courseList.get(i));
        }
        return true;
    }

    public void clear() {
        courses.clear();
    }
    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
         for (int i = 0;i < courses.size();i++ ){
             sb.append(courses.get(i).toString());
         }
             }
}
