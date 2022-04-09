package Kata3_28102020.view;

import Kata3_28102020.model.Histogram;
import Kata3_28102020.persistence.HistogramDisplay;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class D3BarHistogramDisplay extends ApplicationFrame implements HistogramDisplay {
    private final Histogram<String> histogram;
    
    public D3BarHistogramDisplay(String title, Histogram histogram) {
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
        JFreeChart chart = ChartFactory.createBarChart3D("Emails summary", 
                                                         "Email domain", 
                                                         "Emails received", 
                                                         dataSet, 
                                                         PlotOrientation.VERTICAL, 
                                                         false, 
                                                         false, 
                                                         rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key: this.histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet; 
    }
    
    @Override
    public void execute() {
        this.setVisible(true);
    }
    
}
