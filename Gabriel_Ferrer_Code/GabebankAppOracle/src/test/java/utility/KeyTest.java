package utility;
import static org.junit.Assert.assertEquals;

import java.util.TreeMap;

import org.junit.*;

import utility.ds.MapOps;

public class KeyTest {

	@Test
	public void keyMatch() {
		
		assertEquals(true, MapOps.match("currency", 18));
	}
	
	@Test
	public void keyConcat() {
		/// failed but got the results i want
		String expected = "update customer set firstname = 'gabriel',lastname = 'ferrer'";
		String forConcat = "update customer set ";
		TreeMap<String, String> append = new TreeMap<String, String>();
		append.put("firstname","gabriel");
		append.put("lastname","ferrer");

		String result = MapOps.concatStr(append, forConcat);
		System.out.println(result);
		
		assertEquals(expected, MapOps.concatStr(append, result));
	}
}
