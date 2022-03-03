enum room_type{
    LECTURE_HALLS,
    COMPUTER_LABS
}
public class Room {
    room_type type;
    private String name;
    private int capacity;

    public Room(room_type type, String name, int capacity) {
        this.type = type;
        this.name = name;
        this.capacity = capacity;
    }

    public room_type getType() {
        return type;
    }

    public void setType(room_type type) {
        this.type = type;
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
    public String toString() {
        return "Room{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
