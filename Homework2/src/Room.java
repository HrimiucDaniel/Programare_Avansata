import java.util.Objects;

/**
 *Class for creating the rooms in which the events could take place.
 * It has two atributes: the name and the capacity
 * It has constructors, getters and setters, the toString and equals methods
 * It's an abstract class with 2 subclasses: LectureHall and ComputerLabs
 */

public abstract class Room {
    protected String name;
    protected int capacity;

    public Room( String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Room() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity  && Objects.equals(name, room.name);
    }



    @Override
    public String toString() {
        return "Room{" +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
