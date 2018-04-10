package MavenProject.First;
import java.sql.*;

public class ReadData 
{
	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.13/");
		try (Statement stmt = conn.createStatement()) {
		    try (ResultSet rs =
		    stmt.executeQuery("SELECT p.name, c.name " +
		    " FROM Person p, City c " +
		    " WHERE p.city_id = c.id")) {
		      while (rs.next())
		         System.out.println(rs.getString(1) + ", " + rs.getString(2));
		    }
		}
	}
}
