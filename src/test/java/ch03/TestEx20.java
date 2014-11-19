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

public class TestEx20 extends TestCase {

	public void testMap() throws IOException {

		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("bb");
		list.add("Cc");

		List<String> result = Ex20.map(list, (x) -> x.toLowerCase());

		assertEquals("aa", result.get(0));
		assertEquals("bb", result.get(1));
		assertEquals("cc", result.get(2));
	}

}
