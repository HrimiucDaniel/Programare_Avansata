/**
 * The LectureHall subclass which comes from the abstract class Room
 * It has (besides the atributes and the methods of the Room class) the projector atribute which specifies if the LectureHall has or not a projector
 * It has constructors and getters and setter for the projector atribute, and the toString method
 */
public class LectureHall extends Room{
    private boolean projector;

    public LectureHall(String name, int capacity, boolean projector) {
        super(name, capacity);
        this.projector = projector;
    }

    public LectureHall(boolean projector) {
        this.projector = projector;
    }

    public LectureHall() {
    }

    public boolean isProjector() {
        return projector;
    }

    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    @Override
    public String toString() {
        return "LectureHall{" +
                "projector=" + projector +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
