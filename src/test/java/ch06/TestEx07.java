/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.util.concurrent.ConcurrentHashMap;

import junit.framework.TestCase;

public class TestEx07 extends TestCase {


	public void testgetKey() {

		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();

		map.put("1", Long.valueOf(1L));
		map.put("2", Long.valueOf(2L));
		map.put("3", Long.valueOf(3L));

		assertEquals("3", Ex07.getKeyOfMaxValue(map));
	}

}
