/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestEx23 extends TestCase {

	public void testMap() throws IOException {

		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("bb");
		list.add("Cc");

		Ex23.Pair<String> p = new Ex23.Pair<String>("AA", "BB");

		Ex23.Pair<String> result = Ex23.map(p, (x) -> x.toLowerCase());

		assertEquals("aa", result.value1);
		assertEquals("bb", result.value2);
	}

}
