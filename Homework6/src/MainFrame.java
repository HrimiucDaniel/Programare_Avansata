import javax.swing.JFrame;
import java.awt.*;
import java.net.NoRouteToHostException;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        this.init();
    }

   public void init() {
        this.setDefaultCloseOperation(3);
       this.configPanel = new ConfigPanel(this);
       add(configPanel, NORTH);
        this.canvas = new DrawingPanel(this);
        add(canvas, CENTER);
        this.controlPanel = new ControlPanel(this);
        add(controlPanel, SOUTH);
        this.pack();


    }
}
