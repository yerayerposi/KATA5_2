package KATA5P2.main;

import java.io.IOException;
import java.util.List;
import KATA5P2.model.Histogram;
import KATA5P2.model.Mail;
import KATA5P2.view.HistogramDisplay;
import KATA5P2.view.MailHistogramBuilder;
import KATA5P2.view.MailListReaderDDBB;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class KATA5P2 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        KATA5P2 kata5 = new KATA5P2();
        kata5.execute();
    }
    
    private Histogram<String> histogram;
    private List<Mail> mailList;
    
    private void execute() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    
    
    private void input() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        mailList = MailListReaderDDBB.read();
    }
    
    
    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}