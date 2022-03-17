import java.util.Map;

/**
 * The Switch class is a subclass of the Node class
 */

public class Switch extends Node{
    public Switch(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name='" + name + '\'' +
                '}';
    }
}
