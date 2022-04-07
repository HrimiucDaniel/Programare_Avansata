import javax.naming.RefAddr;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile>  letters = new ArrayList<>();
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
          letters.add(new Tile(c,10));
        }
    }


    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            Random rand = new Random();
            int x_rand = rand.nextInt(10);
            extracted.add(letters.get(x_rand));
        }
        return extracted;
    }
}