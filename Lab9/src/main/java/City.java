import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class City {
    public City(String name, Boolean bool,int id, int nr2) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }

    }
}
