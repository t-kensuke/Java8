/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.util.List;

import junit.framework.TestCase;

public class TestEx09 extends TestCase {

	public void testFibonacci() {
		List result = Ex09.fibonacci(10);

		assertEquals(1L, result.get(0));
		assertEquals(1L, result.get(1));
		assertEquals(2L, result.get(2));
		assertEquals(3L, result.get(3));
		assertEquals(5L, result.get(4));
		assertEquals(8L, result.get(5));
		assertEquals(13L, result.get(6));
		assertEquals(21L, result.get(7));
		assertEquals(34L, result.get(8));
		assertEquals(55L, result.get(9));
		assertEquals(89L, result.get(10));

	}

}
