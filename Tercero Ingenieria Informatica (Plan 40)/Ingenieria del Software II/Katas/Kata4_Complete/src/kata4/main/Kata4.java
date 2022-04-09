
package kata4.main;

import kata4.ui.MailHistogramBuilder;
import kata4.ui.MailListReader;
import kata4.ui.HistogramDisplay;
import kata4.model.Mail;
import kata4.model.Histogram;
import java.util.List;


public class Kata4 {
    private static List<Mail> mailList;
    private static Histogram <String> mailHistogram;
    
    public static void main(String[] args) {
       execute(); 
    }
    
    private static void execute() {
        input();
        process();
        output();
    }
    
    private static void input() {
        String fileName = new String("emails.txt");
        mailList = MailListReader.read(fileName);
    }
    
    private static void process() {
        mailHistogram = MailHistogramBuilder.build(mailList);

    }
    
    private static void output() {
        new HistogramDisplay("HISTOGRAMA",mailHistogram).execute();
    }
    
}
