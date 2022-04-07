import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {this.name = name;}

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        //create a word will all tiles
        String word = extracted.toString();
        game.getBoard().AddWord(this,word);
        sleep(50);
        return true;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void run() {
        try {
            this.submitWord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(game.getBoard().toString());

    }
}
