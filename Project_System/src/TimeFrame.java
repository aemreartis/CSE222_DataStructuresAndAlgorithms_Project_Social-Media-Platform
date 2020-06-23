public class TimeFrame{
    private String day;
    private Time startTime;
    private Time finishTime;
    private int numOfParticipent;


    public TimeFrame(String day, Time startTime, Time finishTime) {
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

    public int getNumOfParticipent() {
        return numOfParticipent;
    }

    public void setNumOfParticipent(int numOfParticipent) {
        this.numOfParticipent = numOfParticipent;
    }
}