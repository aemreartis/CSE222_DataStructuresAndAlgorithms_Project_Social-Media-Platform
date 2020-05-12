import java.util.ArrayList;

public class Event implements Comparable<Event> {
    Interest interest;
    String id;
    String name;
    String description;
    Date date;
    Time startTime;
    Time finishTime;
    User owner;
    ArrayList<User> participants;

    public Event(String id, String name, String description, Date date, Time startTime, Time finishTime, User owner, ArrayList<User> participants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.participants = participants;
        this.date = date;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }


    @Override
    public int compareTo(Event o) {
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }
}
