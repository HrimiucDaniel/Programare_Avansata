import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog, String path) throws IOException{
        try (var oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(catalog);
        }
    }
    public static Catalog load(String path) throws IOException {
        Catalog catalog = new Catalog();
        try (var oos = new ObjectInputStream(new FileInputStream(path))){
            catalog = (Catalog) oos.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return catalog;
    }
    public static void add(Catalog catalog, Item item) {
        catalog.add(item);
    }

    public String toString(Catalog catalog) {
        return catalog.toString();
    }
}

