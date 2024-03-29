package MavenProject.First;
import java.sql.*;

public class IgniteData 
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.13/");
		try (Statement stmt = conn.createStatement()) {
		    stmt.executeUpdate("CREATE TABLE City (" + 
		    " id LONG PRIMARY KEY, name VARCHAR) " +
		    " WITH \"template=replicated\"");
		    stmt.executeUpdate("CREATE TABLE Person (" +
		    " id LONG, name VARCHAR, city_id LONG, " +
		    " PRIMARY KEY (id, city_id)) " +
		    " WITH \"backups=1, affinityKey=city_id\"");
		    stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");
		    stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");
		}
		System.out.println("Tables created");
	}
}
