import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand {
    public static Catalog load(String path) {
        Catalog catalog = new Catalog();
        try (var oos = new ObjectInputStream(new FileInputStream(path))) {
            catalog = (Catalog) oos.readObject();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return catalog;
    }
}
