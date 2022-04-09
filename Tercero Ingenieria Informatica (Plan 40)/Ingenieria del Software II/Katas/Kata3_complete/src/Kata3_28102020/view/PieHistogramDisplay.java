package Kata3_28102020.view;

import Kata3_28102020.model.Histogram;
import Kata3_28102020.persistence.HistogramDisplay;
import java.util.Locale;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class PieHistogramDisplay extends ApplicationFrame implements HistogramDisplay {
    private final Histogram<String> histogram;
    
    public PieHistogramDisplay(String title, Histogram histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    
    private JFreeChart createChart(PieDataset dataSet){
        JFreeChart chart = ChartFactory.createPieChart("Emails Received", 
                                                       dataSet, 
                                                       rootPaneCheckingEnabled, 
                                                       rootPaneCheckingEnabled, 
                                                       Locale.ITALY);
        return chart;
    }
    
    private PieDataset createDataset(){
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for(String key: this.histogram.keySet()){
            dataSet.setValue(key, histogram.get(key));
        }
        return dataSet; 
    }

    @Override
    public void execute() {
        this.setVisible(true);
    }
    
}
