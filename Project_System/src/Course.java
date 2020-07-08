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

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public Time getStartTime() {
            return startTime;
        }

        public void setStartTime(Time startTime) {
            this.startTime = startTime;
        }

        public Time getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(Time finishTime) {
            this.finishTime = finishTime;
        }
    }

    String id;
    String name;
    String lecturer;
    ArrayList<Section> sections;
    ArrayList<String> students;

    public Course(String id, String name, String lecturer, ArrayList<Section> sections, ArrayList<String> students) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        for (int i = 0; i < sections.size(); i++) {
            this.sections.add(sections.get(i));
        }
        for (int i = 0; i < students.size(); i++) {
            this.students.add(students.get(i));
        }
    }

    public ArrayList<Section> getSections() {
        return sections;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", lecturer='" + lecturer + '\'' +
                '}';
    }
}
