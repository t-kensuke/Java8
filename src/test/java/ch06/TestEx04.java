/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.util.stream.LongStream;

import junit.framework.TestCase;

public class TestEx04 extends TestCase {

	public void testMaxValue() {
		LongStream longStream = LongStream.of(1L, 2L, 3L);
		assertEquals(3L, Ex04.maxValue(longStream));

		LongStream longStream2 = LongStream.of(1L);
		assertEquals(1L, Ex04.maxValue(longStream2));

		try {
			Ex04.maxValue(null);
			fail();
		} catch (Exception e) {
		}
	}

	public void testMinValue() {
		LongStream longStream = LongStream.of(1L, 2L, 3L);
		assertEquals(1L, Ex04.minValue(longStream));

		LongStream longStream2 = LongStream.of(1L);
		assertEquals(1L, Ex04.minValue(longStream2));

		try {
			Ex04.minValue(null);
			fail();
		} catch (Exception e) {
		}
	}
}
