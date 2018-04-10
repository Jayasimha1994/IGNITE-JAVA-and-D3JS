package MavenProject.First;
import java.sql.*;

public class DropTable 
{
	public static void main(String[] args)throws Exception 
	{
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.13/");
		try (Statement stmt = conn.createStatement()) 
		{
		    stmt.execute("drop table city");
		    stmt.execute("drop table person");
		}
		System.out.println("Truncated");
	}
}
