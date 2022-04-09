package kata_28102020.control;

import Kata3_28102020.model.Histogram;
import Kata3_28102020.persistence.HistogramDisplay;
import Kata3_28102020.persistence.HistogramLoader;
import Kata3_28102020.view.BarHistogramDisplay;
import Kata3_28102020.view.PieHistogramDisplay;
import Kata3_28102020.view.D3BarHistogramDisplay;

public final class HistogramMemoryLoader implements HistogramLoader{
    private final Histogram<String> histogram;
    private HistogramDisplay histogramFX;
    
    public HistogramMemoryLoader(int type) {
        this.histogram = new Histogram();
        this.histogramFX = null;
        load();
        checkType(type);
        histogramFX.execute();  
    }
    
    @Override
    public void load(){ 
        histogram.increment("ulpgc.es");
        histogram.increment("ull.es");
        histogram.increment("hotmail.es");
        histogram.increment("hotmail.es");
        histogram.increment("udlaspalmas.es");
        histogram.increment("hotmail.es");
        histogram.increment("udlaspalmas.es");
        histogram.increment("hotmail.es");
        histogram.increment("udlaspalmas.es");
    }
    
    private void checkType(int type){
        switch(type){
            case 1:
                histogramFX = new BarHistogramDisplay("HISTOGRAM", histogram);
                break;
            case 2:
                histogramFX= new D3BarHistogramDisplay("HISTOGRAM", histogram);
                break;
            case 3:
                histogramFX = new PieHistogramDisplay("HISTOGRAM", histogram);
                break;
            default:
                histogramFX = null;
                break;
        }  
    }
}
