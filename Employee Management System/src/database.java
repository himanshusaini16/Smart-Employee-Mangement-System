import java.sql.*;

public class database {
    Connection c;
    Statement s;

    public database () {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "Saini@161114");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}