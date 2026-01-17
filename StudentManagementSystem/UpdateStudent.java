import java.sql.*;

public class UpdateStudent {
    public static void update(int id, String name, int marks) throws Exception {
        Connection con = DBConnection.connect();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE students SET name=?, marks=? WHERE id=?"
        );
        ps.setString(1, name);
        ps.setInt(2, marks);
        ps.setInt(3, id);
        ps.executeUpdate();
    }
}
