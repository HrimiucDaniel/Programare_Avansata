import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 500, canvasHeight = 500;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 25;
    BufferedImage image;
    Graphics2D offscreen;
    Boolean red;
    Boolean sticks;
    List<Pair> ok_h = new ArrayList<>();
    List<Pair> ok_v = new ArrayList<>();
    List<Pair> colorat = new ArrayList<>();
    public int count_stone(){
        int count = 0;
        for (int row = 0; row< rows ; row++) {
            for (int col = 0; col< cols; col++) {
                Boolean found = false;
                for (Pair t:ok_h) {
                    if(t.getX() == row && t.getY() == col) {
                        found = true;
                        count++;
                    }
                }
                if (!found)
                for (Pair t:ok_v) {
                    if(t.getX() == col  && t.getY() == row ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(),frame.configPanel.getCols());
    }
    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    public void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        red = sticks = true;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                drawStone(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawStone(int x, int y) {
        Boolean cond = false;
        int xq, yq;
        xq = yq = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                xq = padX + col * cellWidth;
                yq = padY + row * cellHeight;
                if (x > (xq - stoneSize/2) && x < (xq - stoneSize/2) + stoneSize)
                    if (y > (yq - stoneSize/2) && y <  (yq - stoneSize/2) + stoneSize) {
                        Boolean bul = true;
                        Pair temp = new Pair();
                        temp.setX(row);
                        temp.setY(col);
                        for (Pair t:colorat) {
                            if (t.getX() == temp.getX() && t.getY() == temp.getY()) bul = false;

                        }

                        if (bul == false) break;
                       for (Pair t:ok_h) {
                           if(t.getX() == row && t.getY() == col) {
                               ok_h.remove(t);
                               cond = true;
                               colorat.add(temp);
                               break;

                           }
                       }

                       for (Pair t:ok_v) {
                           if(t.getX() == col  && t.getY() == row ) {
                               ok_v.remove(t);
                               cond = true;
                               colorat.add(temp);
                               break;
                           }
                       }
                        if (cond) break;
                    }
            }
            if (cond) break;
        }
        if (cond) {
            if (red) {offscreen.setColor(Color.RED);red = false;}
            else {offscreen.setColor(Color.BLUE);red = true;}
            offscreen.fillOval(xq - stoneSize / 2, yq - stoneSize / 2, stoneSize, stoneSize);
            System.out.println(this.count_stone());
            if (this.count_stone() == 0 && red) System.out.println("Blue wins!!");
            else if (this.count_stone() == 0 && !red) System.out.println("Red wins!!!");
        }

    }





    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
       if (sticks) paintSticks(g);
       paintGrid(g);
       graphics.drawImage(image, 0, 0, this);



    }
    public void paintSticks(Graphics2D graphics) {
        Random rand = new Random();
        int rcol = rand.nextInt(cols,cols*3);
        int rrow = rand.nextInt(rows,rows*3);
        System.out.println(rrow);
        offscreen.setColor(Color.black);
        offscreen.setStroke(new BasicStroke(5));
        while (rrow != 0) {
            for (int row = 0; row < rows; row++) {
                int x = rand.nextInt(2);

                if (x != 0) {
                    for (int col = 0; col < cols - 1; col++) {
                        int y = rand.nextInt(2);
                        if (y != 0) {
                            int cond = 1;
                            Pair temp = new Pair();
                            temp.setX(row);
                            temp.setY(col);
                            for (Pair t: ok_h) {
                                if (t.getX() == temp.getX() && t.getY() == temp.getY()) cond = 0;
                            }
                            for (Pair t: ok_v) {
                                if (t.getX() == temp.getY() && t.getY() == temp.getX()) cond = 0;
                            }
                            if (cond == 1) ok_h.add(temp);
                            Pair temp2 = new Pair();
                            temp2.setX(row);
                            temp2.setY(col+1);
                            cond = 1;
                            for (Pair t: ok_h) {
                                if (t.getX() == temp2.getX() && t.getY() == temp2.getY())   cond = 0;
                            }
                            for (Pair t: ok_v) {
                                if (t.getX() == temp2.getY() && t.getY() == temp2.getX()) cond = 0;
                            }
                            if (cond == 1) ok_h.add(temp2);

                            rrow--;

                            int x1 = padX + (stoneSize/2) + (col * cellWidth);
                            int y1 = padY + row * cellHeight;
                            int x2 = x1 + stoneSize;
                            int y2 = y1;
                            offscreen.drawLine(x1, y1, x2, y2);
                            if (rrow == 0) break;
                        }
                    }

                }
                if (rrow == 0) break;
            }
        }

        while (rcol != 0) {
            for (int row = 0; row < cols; row++) {
                int x = rand.nextInt(2);
                 if (x != 0) {
                   for (int col = 0; col < rows - 1; col++) {
                        int y = rand.nextInt(2);
                        if (y != 0) {
                            int cond =1;
                            Pair temp = new Pair();
                            temp.setX(row);
                            temp.setY(col);
                            for (Pair t: ok_v) {
                                if (t.getX() == temp.getX() && t.getY() == temp.getY()) cond = 0;
                            }
                            for (Pair t: ok_h) {
                                if (t.getX() == temp.getY() && t.getY() == temp.getX()) cond = 0;
                            }
                            if (cond == 1) ok_v.add(temp);
                            Pair temp2 = new Pair();
                            temp2.setY(col+1);
                            temp2.setX(row);
                            cond = 1;
                            for (Pair t: ok_v) {
                                if (t.getX() == temp2.getX() && t.getY() == temp2.getY()) cond = 0;
                            }
                            for (Pair t: ok_h) {
                                if (t.getX() == temp2.getY() && t.getY() == temp2.getX()) cond = 0;
                            }
                            if (cond == 1)ok_v.add(temp2);
                            rcol--;

                            int x1 = padX + (stoneSize/2) + (col * cellWidth);
                            int y1 = padY + row * cellHeight;
                            int x2 = x1 + stoneSize;
                            int y2 = y1;
                            offscreen.drawLine(y1, x1, y2, x2);
                            if (rcol  == 0) break;
                        }
                    }
                }
                if (rcol == 0) break;
            }
        }
        sticks = false;

    }




    public void paintGrid(Graphics2D g) {
        offscreen.setColor(Color.LIGHT_GRAY);
        offscreen.setStroke(new BasicStroke(2));
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int x1 = padX + (stoneSize/2) + (col * cellWidth);
                int y1 = padY + row * cellHeight;
                int x2 = x1 + stoneSize;
                int y2 = y1;
                offscreen.drawLine(x1, y1, x2, y2);
            }
        }

        //vertical lines
        for (int row = 0; row < cols; row++) {
            for (int col = 0; col < rows - 1; col++) {
                int x1 = padX + (stoneSize / 2) + (col * cellWidth);
                int y1 = padY + row * cellHeight;
                int x2 = x1 + stoneSize;
                int y2 = y1;
                offscreen.drawLine(y1, x1, y2, x2);
            }
        }

        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }


    }


}
