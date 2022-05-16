import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running = true;
    private int scor_total = 0;
      static int id_static = 0;
      private int id = 0;
    public Player(String name) {this.name = name;id_static++; this.id = id_static;}
    public void getId(){System.out.println(id);}

    private String generateWord(List<Tile> extracted){
        char[] c7 = new char[7];
        for(Tile t0 : extracted) {
            List<Tile> temp0 = new ArrayList<>(extracted);
            c7[0]=t0.getLetter();
            temp0.remove(t0);
            for (Tile t1 : temp0){
                List<Tile> temp1 = new ArrayList<>(temp0);
                c7[1]=t1.getLetter();
                temp1.remove(t1);
                for (Tile t2 : temp1){
                    List<Tile> temp2 = new ArrayList<>(temp1);
                    c7[2] = t2.getLetter();
                    temp2.remove(t2);
                    for (Tile t3 : temp2){
                        List<Tile> temp3 = new ArrayList<>(temp2);
                        c7[3] = t3.getLetter();
                        temp3.remove(t3);
                        for (Tile t4 : temp3){
                            List<Tile> temp4 = new ArrayList<>(temp3);
                           c7[4] = t4.getLetter();
                            temp4.remove(t4);
                            for (Tile t5 : temp4){
                                List<Tile> temp5 = new ArrayList<>(temp4);
                                c7[5]=t5.getLetter();
                                temp5.remove(t5);
                                for (Tile t6 : temp5){
                                    c7[6]=t6.getLetter();
                                    String s = new String(c7);

                                    if (game.getDictionary().isWord(s)) return s;
                                }
                            }
                        }
                    }
                }
            }
        }


        char[] c6 = new char[6];
        for(Tile t0 : extracted) {
            List<Tile> temp0 = new ArrayList<>(extracted);
            c6[0]=t0.getLetter();
            temp0.remove(t0);
            for (Tile t1 : temp0){
                List<Tile> temp1 = new ArrayList<>(temp0);
                c6[1]=t1.getLetter();
                temp1.remove(t1);
                for (Tile t2 : temp1){
                    List<Tile> temp2 = new ArrayList<>(temp1);
                    c6[2] = t2.getLetter();
                    temp2.remove(t2);
                    for (Tile t3 : temp2){
                        List<Tile> temp3 = new ArrayList<>(temp2);
                        c6[3] = t3.getLetter();
                        temp3.remove(t3);
                        for (Tile t4 : temp3){
                            List<Tile> temp4 = new ArrayList<>(temp3);
                            c6[4] = t4.getLetter();
                            temp4.remove(t4);
                            for (Tile t5 : temp4){
                                c6[5]=t5.getLetter();
                                String s = new String(c6);

                                if (game.getDictionary().isWord(s)) return s;
                            }
                        }
                    }
                }
            }
        }

        char[] c5 = new char[5];
        for(Tile t0 : extracted) {
            List<Tile> temp0 = new ArrayList<>(extracted);
            c5[0]=t0.getLetter();
            temp0.remove(t0);
            for (Tile t1 : temp0){
                List<Tile> temp1 = new ArrayList<>(temp0);
                c5[1]=t1.getLetter();
                temp1.remove(t1);
                for (Tile t2 : temp1){
                    List<Tile> temp2 = new ArrayList<>(temp1);
                    c5[2] = t2.getLetter();
                    temp2.remove(t2);
                    for (Tile t3 : temp2){
                        List<Tile> temp3 = new ArrayList<>(temp2);
                        c5[3] = t3.getLetter();
                        temp3.remove(t3);
                        for (Tile t4 : temp3){
                            c5[4] = t4.getLetter();
                            String s = new String(c5);
                            if (game.getDictionary().isWord(s)) return s;

                        }
                    }
                }
            }
        }

        char[] c4 = new char[4];
        for(Tile t0 : extracted) {
            List<Tile> temp0 = new ArrayList<>(extracted);
            c4[0]=t0.getLetter();
            temp0.remove(t0);
            for (Tile t1 : temp0){
                List<Tile> temp1 = new ArrayList<>(temp0);
                c4[1]=t1.getLetter();
                temp1.remove(t1);
                for (Tile t2 : temp1){
                    List<Tile> temp2 = new ArrayList<>(temp1);
                    c4[2] = t2.getLetter();
                    temp2.remove(t2);
                    for (Tile t3 : temp2){
                        c4[3] = t3.getLetter();
                        String s = new String(c4);
                        if (game.getDictionary().isWord(s)) return s;
                    }
                }
            }
        }

        char[] c3 = new char[3];
        for(Tile t0 : extracted) {
            List<Tile> temp0 = new ArrayList<>(extracted);
            c3[0]=t0.getLetter();
            temp0.remove(t0);
            for (Tile t1 : temp0){
                List<Tile> temp1 = new ArrayList<>(temp0);
                c3[1]=t1.getLetter();
                temp1.remove(t1);
                for (Tile t2 : temp1){
                    c3[2] = t2.getLetter();
                    String s = new String(c3);
                    if (game.getDictionary().isWord(s)) return s;

                }
            }
        }
        char[] c2 = new char[2];
        for(Tile t0 : extracted) {
            List<Tile> temp0 = new ArrayList<>(extracted);
            c2[0]=t0.getLetter();
            temp0.remove(t0);
            for (Tile t1 : temp0){
                c2[1]=t1.getLetter();
                String s = new String(c2);
               //  System.out.println(s);
                if (game.getDictionary().isWord(s)) return s;


            }
        }

        return null;
    }

    private synchronized boolean submitWord() throws InterruptedException, IOException {


           // game.setAvailableFalse();
            List<Tile> extracted = new ArrayList<>();
            extracted = game.getBag().extractTiles(7);
            if (extracted == null) {
                return false;
            }
            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < extracted.size(); i++) {

                sb.append(extracted.get(i));
                sb.append(" ");
            }


            System.out.println(this.getName() + ": " + sb);
            String word = this.generateWord(extracted);
            while (word == null) {
                extracted = game.getBag().extractTiles(7);
                if (extracted == null) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder("");

                for (int i = 0; i < extracted.size(); i++) {

                    sb2.append(extracted.get(i));
                    sb2.append(" ");
                }


                System.out.println(this.getName() + ": " + sb);
                 word = this.generateWord(extracted);
            }
            int x = 0;
            for (int i = 0; i < word.length(); i++) {
                char a = word.charAt(i);
                x += Tile.getPoints(a);
            }
            x = x * word.length();

            String s = Integer.toString(x);

            if (word != null) {
                System.out.println(this.getName() + ":" + word + " (" + s + " puncte" + ")");
                game.getBoard().AddWord(this, word);
                scor_total += x;
            } else System.out.println(this.getName() + ": 0 puncte");

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
    public int getScor_total(){return scor_total;}
    public boolean running(){return  running;}
    public void run() {
        try {
            while (this.submitWord() == true) {};
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(game.getBoard().toString());
    }
}
