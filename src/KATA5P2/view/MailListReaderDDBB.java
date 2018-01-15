package KATA5P2.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import KATA5P2.model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MailListReaderDDBB {
    public static List<Mail> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        List<Mail> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String UrlConnection ="jdbc:sqlite:KATA5.DB";
        Connection connection = DriverManager.getConnection(UrlConnection);
        
        Statement st = connection.createStatement();
        
        String query ="SELECT * FROM MAIL";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            mailList.add(new Mail(rs.getString(2)));
        }
        
        return mailList;
    }
    
}
