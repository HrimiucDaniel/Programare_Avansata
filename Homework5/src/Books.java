import java.io.Serializable;

public class Books extends Item implements Serializable {
    public Books() {
    }

    public Books(String id, String title, String location) {
        super(id, title, location);
    }


}
