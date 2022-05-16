import javax.xml.crypto.Data;
import java.sql.*;

public class Continent {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }

    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select name from continents where id='" + Integer.toString(id) + "'")){
            return rs.next() ? rs.getString(1):null;
        }
    }
}
