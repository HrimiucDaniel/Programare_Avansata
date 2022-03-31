import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner spinner2;
    JButton createBtn;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(10,2,100,1));
        createBtn = new JButton("Create");


        add(label);
        add(spinner);
        add(spinner2);
        add(createBtn);
    }
}
