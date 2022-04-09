
package kata4.ui;

import kata4.model.Mail;
import kata4.model.Histogram;
import java.util.List;

public class MailHistogramBuilder {

    public static Histogram<String> build(List<Mail> mailList) {
        Histogram<String> histogram = new Histogram();
        for (Mail mail : mailList) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }

}
