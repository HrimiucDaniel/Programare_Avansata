public class Tile {
    private final char letter;
   private int points  = 0;

    public Tile(char letter) {
        this.letter = letter;
        if (this.letter == 'a' || this.letter == 'e' || this.letter == 'i' || this.letter == 'o' ||  this.letter == 'u'|| this.letter == 'l' || this.letter == 'n' || this.letter == 's' || this.letter == 't' || this.letter == 'r') this.points = 1;
        else if (this.letter == 'd' || this.letter == 'g') this.points = 2;
        else if (this.letter == 'b' || this.letter == 'c' || this.letter == 'm' || this.letter == 'p') this.points = 3;
        else if (this.letter == 'f' || this.letter == 'h' || this.letter == 'v' || this.letter == 'w' || this.letter == 'y') this.points = 4;
        else if (this.letter == 'k') this.points = 5;
        else if(this.letter == 'j' || this.letter == 'x') this.points = 8;
        else if (this.letter == 'q' || this.letter == 'z') this.points = 10;
    }
    public static int getPoints(char letter) {
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' ||  letter == 'u'|| letter == 'l' || letter == 'n' || letter == 's' || letter == 't' || letter == 'r') return 1;
        else if (letter == 'd' || letter == 'g') return 2;
        else if (letter == 'b' || letter == 'c' || letter == 'm' || letter == 'p') return 3;
        else if (letter == 'f' || letter == 'h' || letter == 'v' || letter == 'w' || letter == 'y') return 4;
        else if (letter == 'k') return 5;
        else if(letter == 'j' || letter == 'x') return 8;
        else if (letter == 'q' || letter == 'z') return 10;
        return 0;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(letter);
        String s = sb.toString();
        return s;
    }
}

