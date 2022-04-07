import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        this.init();
    }

    private void init() {
        this.setLayout(new GridLayout(1, 4));
        this.add(this.exitBtn);
        this.add(this.loadBtn);
        this.add(this.saveBtn);
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
    }

    private void exitGame(ActionEvent e) {
        this.frame.dispose();
    }

    private void loadGame(ActionEvent e) {
    }

    private void saveGame(ActionEvent e) {
    }
}
