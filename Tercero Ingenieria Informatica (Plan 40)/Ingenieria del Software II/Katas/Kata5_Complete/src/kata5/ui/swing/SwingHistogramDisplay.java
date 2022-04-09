package kata5.ui.swing;

import kata5.model.Histogram;
import javax.swing.JPanel;
import kata5.ui.persistence.HistogramDisplay;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class SwingHistogramDisplay extends ApplicationFrame implements HistogramDisplay {
    private final Histogram<String> histogram;
    
    public SwingHistogramDisplay(String title, Histogram histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Emails Received", 
                                                       "Email domains", 
                                                       "Emails Received", 
                                                       dataSet, 
                                                       PlotOrientation.VERTICAL, 
                                                       false, 
                                                       false, 
                                                       rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int others=0;
        for(String key: this.histogram.keySet()){
            if(this.histogram.get(key) == 1) others++;
            else dataSet.addValue(histogram.get(key), "", key);
        }
        dataSet.addValue(others, "", "Others");
        return dataSet; 
    }
    
    @Override
    public void execute(){
        this.setVisible(true);
    }
}
