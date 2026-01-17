import java.sql.*;

public class DBConnection {
    public static Connection connect() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sms",
            "root",
            "password"
        );
    }
}
