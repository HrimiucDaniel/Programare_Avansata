import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.BorderLayout.CENTER;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner spinner2;
    JButton createBtn;
    private int rows,cols;
    private boolean crt_btn;

    public boolean isCrt_btn() {
        return crt_btn;
    }

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        this.init();
        rows = cols = 10;
    }
    public int getRows(){
        return rows;
    }
    public  int getCols(){
        return cols;
    }

    private void init() {
        this.label = new JLabel("Grid size:");
        this.spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        this.spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        this.createBtn = new JButton("Create");
        createBtn.addActionListener(this::Create);
        this.add(this.label);
        this.add(this.spinner);
        this.add(this.spinner2);
        this.add(this.createBtn);
    }
    private void Create(ActionEvent e){
        this.rows = (int) spinner.getValue();
        this.cols = (int) spinner2.getValue();
        System.out.println(rows);
        System.out.println(cols);
        this.frame.canvas.repaint();

    }

}
