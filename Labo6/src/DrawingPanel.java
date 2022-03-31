

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;


    BufferedImage image;
    Graphics2D offscreen;



    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffScreenImage();
        init(10,10);
    }
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    private void createOffScreenImage(){
        image = new BufferedImage(canvasWidth,canvasHeight,BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0,0,canvasWidth,canvasHeight);

    }
    private void paintGrid(){

    }

    @Override
    public void update(Graphics g) {}

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}