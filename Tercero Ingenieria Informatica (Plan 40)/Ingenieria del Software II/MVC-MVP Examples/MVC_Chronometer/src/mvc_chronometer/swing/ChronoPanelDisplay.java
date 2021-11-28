package mvc_chronometer.swing;

import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Timestamp;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Measure;
import view.ChronoDisplay;

public class ChronoPanelDisplay extends JPanel implements ChronoDisplay {

    private Measure measure;
    private JTextField minsField;
    private JTextField secsField;
    private JTextField millisField;
    
    public ChronoPanelDisplay() {
        this.execute();
    }

    private void execute() {
        this.setLayout(new FlowLayout());
        this.minsField = new JTextField("00");
        this.secsField = new JTextField("00");
        this.millisField = new JTextField("00");
        this.setGraphicStyles();
        this.setVisible(true);
    }

    private void setGraphicStyles() {
        Font standardFont = new Font("SansSerif", Font.BOLD, 90);
        this.minsField.setFont(standardFont);
        this.secsField.setFont(standardFont);
        this.millisField.setFont(standardFont);
        this.minsField.setEditable(false);
        this.secsField.setEditable(false);
        this.millisField.setEditable(false);
        this.minsField.setBorder(BorderFactory.createTitledBorder("Minutos"));
        this.secsField.setBorder(BorderFactory.createTitledBorder("Segundos"));
        this.millisField.setBorder(BorderFactory.createTitledBorder("Milisegundos"));
        JLabel colon1 = new JLabel(":");
        JLabel colon2 = new JLabel(":");
        colon1.setFont(standardFont);
        colon2.setFont(standardFont);
        this.add(this.minsField);
        this.add(colon1);
        this.add(this.secsField);
        this.add(colon2);
        this.add(this.millisField);
    }
    
    @Override
    public void display(Measure measure) {
        this.measure = measure;
    }

    @Override
    public void change() {
        String time = new Timestamp(this.measure.getCount()).toString();
        this.millisField.setText(time.substring(time.lastIndexOf(".")+1, time.length()));
        this.secsField.setText(time.substring(time.lastIndexOf(":")+1, time.lastIndexOf(".")));
        this.minsField.setText(time.substring(time.indexOf(":")+1, time.lastIndexOf(":")));
    }


    
}
