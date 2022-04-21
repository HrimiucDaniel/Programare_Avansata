import javax.naming.RefAddr;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile>  letters = new ArrayList<>();
    public Bag() {
        for (int i = 1; i <= 9; i++) letters.add(new Tile('a'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('b'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('c'));
        for (int i = 1; i <= 4; i++) letters.add(new Tile('d'));
        for (int i = 1; i <= 12; i++) letters.add(new Tile('e'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('f'));
        for (int i = 1; i <= 3; i++) letters.add(new Tile('g'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('h'));
        for (int i = 1; i <= 9; i++) letters.add(new Tile('i'));
        for (int i = 1; i <= 1; i++) letters.add(new Tile('j'));
        for (int i = 1; i <= 1; i++) letters.add(new Tile('k'));
        for (int i = 1; i <= 4; i++) letters.add(new Tile('l'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('m'));
        for (int i = 1; i <= 6; i++) letters.add(new Tile('n'));
        for (int i = 1; i <= 8; i++) letters.add(new Tile('o'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('p'));
        for (int i = 1; i <= 1; i++) letters.add(new Tile('q'));
        for (int i = 1; i <= 6; i++) letters.add(new Tile('r'));
        for (int i = 1; i <= 4; i++) letters.add(new Tile('s'));
        for (int i = 1; i <= 6; i++) letters.add(new Tile('t'));
        for (int i = 1; i <= 4; i++) letters.add(new Tile('u'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('v'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('w'));
        for (int i = 1; i <= 1; i++) letters.add(new Tile('x'));
        for (int i = 1; i <= 2; i++) letters.add(new Tile('y'));
        for (int i = 1; i <= 1; i++) letters.add(new Tile('z'));


    }



    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                return null;
            }

                Random x = new Random();
                int x_rand = x.nextInt(letters.size());
                extracted.add(letters.get(x_rand));
                letters.remove(x_rand);

        }
        return extracted;
    }
}