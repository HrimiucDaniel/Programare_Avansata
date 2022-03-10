/**
 * The ComputerLab subclass which comes from the abstract class Room
 * It has (besides the atributes and the methods of the Room class) the os atribute which specifies the operating system for the lab computers
 * It has constructors and getters and setter for the os atribute, and the toString method
 */
public class ComputerLab extends Room{
    private String os;

    public ComputerLab(String name, int capacity, String os) {
        super(name, capacity);
        this.os = os;
    }

    public ComputerLab(String os) {
        this.os = os;
    }

    public ComputerLab() {
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "ComputerLab{" +
                "os='" + os + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
