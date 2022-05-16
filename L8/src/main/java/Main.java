import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            var continents = new ContinentDAO();
            continents.create("Afrika",3);
            //System.out.println(continents.findByName("Europe"));
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europa");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();
            System.out.println(continents.findById(3));
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}