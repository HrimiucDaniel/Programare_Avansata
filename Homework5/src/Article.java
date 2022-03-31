import java.io.Serializable;

public class Article extends Item implements Serializable {
    public Article() {
    }

    public Article(String id, String title, String location) {
        super(id, title, location);
    }
}
