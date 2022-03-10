import java.util.Objects;
/**
 *Class for creating the events that take place
 * It has four atributes: the name, the size of the event, the start and end times
 * It has constructors, getters and setters, the toString and equals methods
 */
public class Event {
    private int start, end;
    private int size;
    private String name;

    public Event(int start, int end, int size, String name) {
        this.start = start;
        this.end = end;
        this.size = size;
        this.name = name;
    }

    public Event() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return start == event.start && end == event.end && size == event.size && Objects.equals(name, event.name);
    }

    @Override
    public String toString() {
        return "Event{" +
                "start=" + start +
                ", end=" + end +
                ", size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}