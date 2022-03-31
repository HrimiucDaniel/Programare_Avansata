import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        add(canvas,CENTER);
        controlPanel = new ControlPanel(this);
        //add(controlPanel,SOUTH);
        configPanel = new ConfigPanel(this);
        add(configPanel,NORTH);

        pack();
    }


}
