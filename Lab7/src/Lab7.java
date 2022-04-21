public class Lab7 {
    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));


        //System.out.println(game.getBag().extractTiles(3));
        //System.out.println(game.getBoard().toString());
        game.play();

    }

}
