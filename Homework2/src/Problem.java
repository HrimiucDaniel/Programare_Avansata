import java.util.Arrays;

/**
 * the Class that specifies an instance of the problem
 * it has an array for Events and one for Rooms and the number of events and rooms for atributes
 * it has contructors fetter and setter for rooms,events,rooms number and evente number and the toString method for display
 *
 */
public class Problem {
    private Event[] events;
    private Room[] rooms;
    private int n = 0, m = 0;

    public Problem() {
        events = new Event[10];
        rooms = new Room[10];
    }

    public int getEventsNumber(){
        return n;
    }

    public int getRooomsNumber(){
        return m;
    }


    public Event[] getEvents() {
        return events;
    }
    public Event getEvent(int i) {
        if (i <= n) return events[i];
        return null;
    }
    public Room getRoom(int i) {
        if (i <= m) return rooms[i];
        return null;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void addEvent(Event e){
        for (int i = 0; i <= n; i++) {
            if (e.equals(events[i])) {
                return;
            }
        }

        events[n] = e;
        n++;
    }

    public void addRoom(Room r) {
        for (int i = 0; i <= n; i++) {
            if (r.equals(rooms[i])) {
                return;
            }
        }

        rooms[m] = r;
        m++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(events[i].toString());
            sb.append(",");
        }
        sb.append("\n");
        for (int i = 0; i < m; i++) {
            sb.append(rooms[i].toString());
            sb.append(",");
        }
        String singleString = sb.toString();
        return singleString;
    }
}
