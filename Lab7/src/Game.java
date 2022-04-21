import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    private boolean available = false;
    private int inc = 0;
    public Game() {
    }
    public void Inc(){
        inc++;
        if (inc > players.size()) inc = 1;
    }
    public int getInc(){
        return inc;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount(){return players.size();}
    public boolean isAvailable(){return available;}
    public void setAvailableTrue(){available=true;}
    public void setAvailableFalse(){available=false;}
    public void afiseaza_winner(){
        int maxim = 0;
        String max = null;
        for (Player player: players) {
            if (player.getScor_total() > maxim) {
                maxim = player.getScor_total();
                max = player.getName();
            }
        }
        System.out.println(max+ " " + Integer.toString(maxim)  + " puncte este castigator");
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {

            Runnable runnable = player;
            new Thread(runnable).start();

        }
        while (true) {
            int ok = 0;
            for (Player player : players) {
                if (player.running() == true) ok = 1;
            }
            if (ok==0) break;
        }
        this.afiseaza_winner();


    }


}
