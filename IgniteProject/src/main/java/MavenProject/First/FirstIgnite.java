package MavenProject.First;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;

public class FirstIgnite 
{
	public static void main(String[] args)throws IgniteException 
	{
		try (Ignite ignite = Ignition.start()) 
		{
		      IgniteCache<String, String> cache = ignite.getOrCreateCache("myCache");
		      cache.put("1", "Hello");
		      cache.put("2", "Program");
		      ignite.compute().broadcast(()->System.out.println(cache.get("1") + " " + cache.get("2")));
	    }
	}
}
