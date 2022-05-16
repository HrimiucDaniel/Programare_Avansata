import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cities {
    public void create(String name, boolean capital, float latitude, float longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO cities (name, capital, latitude, longitude) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setBoolean(2, capital);
            pstmt.setFloat(3, latitude);
            pstmt.setFloat(4, longitude);
            pstmt.executeUpdate();
        }
    }

    public City findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select name, capital, latitude, longitude from cities where id='" + id + "'")){
            return rs.next() ? new City(rs.getString(1), rs.getBoolean(2),
                    rs.getInt(3), rs.getInt(4)) : null;
        }
    }

    public City findById(String name) throws SQLException {
        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select name, capital, latitude, longitude from cities where name='" + name + "'")){
            return rs.next() ? new City(rs.getString(1), rs.getBoolean(2),
                    rs.getInt(3), rs.getInt(4)) : null;
        }
    }

    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name, capital, latitude, longitude from cities")) {
            if(rs.next())
                cities.add(new City(rs.getString(1), rs.getBoolean(2),
                        rs.getInt(3), rs.getInt(4)));
        }
        return cities;
    }
}