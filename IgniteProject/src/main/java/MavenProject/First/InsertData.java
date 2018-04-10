package MavenProject.First;
import java.sql.*;

public class InsertData 
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.13/");
		try (PreparedStatement stmt =
		conn.prepareStatement("INSERT INTO City (id, name) VALUES (?, ?)")) {
		    stmt.setLong(1, 1L);
		    stmt.setString(2, "Bangalore");
		    stmt.executeUpdate();
		    stmt.setLong(1, 2L);
		    stmt.setString(2, "Hyderabad");
		    stmt.executeUpdate();
		    stmt.setLong(1, 3L);
		    stmt.setString(2, "Chennai");
		    stmt.executeUpdate();
		}
		try (PreparedStatement stmt =
		conn.prepareStatement("INSERT INTO Person (id, name, city_id) VALUES (?, ?, ?)")) {

		    stmt.setLong(1, 1L);
		    stmt.setString(2, "Jayasimha");
		    stmt.setLong(3, 3L);
		    stmt.executeUpdate();

		    stmt.setLong(1, 2L);
		    stmt.setString(2, "Kavitha");
		    stmt.setLong(3, 2L);
		    stmt.executeUpdate();

		    stmt.setLong(1, 3L);
		    stmt.setString(2, "Manju");
		    stmt.setLong(3, 1L);
		    stmt.executeUpdate();

		    stmt.setLong(1, 4L);
		    stmt.setString(2, "Archana");
		    stmt.setLong(3, 2L);
		    stmt.executeUpdate();
		}
		System.out.println("Inserted Data in to City and Person");
	}
}
