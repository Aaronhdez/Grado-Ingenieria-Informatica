package kata5;

import java.sql.*;
import kata5.persistence.PeopleLoader;
import kata5.persistence.sql.SqlitePeopleLoader;
import kata5.ui.persistence.HistogramDisplay;
import kata5.ui.swing.SwingHistogramDisplay;
import kata5.model.Histogram;
import kata5.model.Person;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PeopleLoader peopleLoader = new SqlitePeopleLoader(); // Cargador de personas
        Histogram<String> histogram = new Histogram();
        for(Person p : peopleLoader.load()){
            System.out.println("?"+p.getEmailDomain()+"?");
            histogram.increment(p.getEmailDomain());
        }
        HistogramDisplay histogramDisplay = new SwingHistogramDisplay("Prueba", histogram);
        histogramDisplay.execute();
    }
}
