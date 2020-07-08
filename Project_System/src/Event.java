import java.util.ArrayList;

public class Event implements Comparable<Event> {
    String id;
    String name;
    String description;
    Date date;
    Time startTime;
    Time finishTime;
    String ownerId;
    ArrayList<String> participants;

    public Event(String id, String name, String description, Date date, Time startTime, Time finishTime, String ownerId, ArrayList<String> participants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
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

    public String getOwner() {
        return ownerId;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }
}
