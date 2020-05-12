import java.util.ArrayList;

public class Club {
    String name;
    Date foundationDate;
    ArrayList<User> foundingMembers;
    BinarySearchTree<Event> clubEvents;


    public Club(String name, Date foundationDate, ArrayList<User> foundingMembers, BinarySearchTree<Event> clubEvents) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.foundingMembers = foundingMembers;
        this.clubEvents = clubEvents;
    }
}
