package ch02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class TestEx13 extends TestCase {

	public void testCount() throws Exception {
		List<String> list = Arrays.asList(new String[]{"1","55555","4444","4444","22", "22","22"});

		Map<Integer, Long> result = Ex13.countWords(list.stream());

		assertEquals(null, result.get(Integer.valueOf(0)));
		assertEquals(Long.valueOf(1), result.get(1));
		assertEquals(Long.valueOf(3), result.get(2));
		assertEquals(null, result.get(3));
		assertEquals(Long.valueOf(2), result.get(4));
		assertEquals(Long.valueOf(1), result.get(5));
		assertEquals(null, result.get(6));
		assertEquals(null, result.get(7));
		assertEquals(null, result.get(8));
		assertEquals(null, result.get(9));
		assertEquals(null, result.get(10));
		assertEquals(null, result.get(11));

	}

}
