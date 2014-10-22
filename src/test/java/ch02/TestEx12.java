package ch02;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.TestCase;

public class TestEx12 extends TestCase {

	public void testCount() throws Exception {
		List<String> list = Arrays.asList(new String[]{"1","55555","4444","4444","22", "22","22"});

		AtomicInteger[] result = Ex12.countWords(list.stream());

		assertEquals(1, result[0].get());
		assertEquals(3, result[1].get());
		assertEquals(0, result[2].get());
		assertEquals(2, result[3].get());
		assertEquals(1, result[4].get());
		assertEquals(0, result[5].get());
		assertEquals(0, result[6].get());
		assertEquals(0, result[7].get());
		assertEquals(0, result[8].get());
		assertEquals(0, result[9].get());
		assertEquals(0, result[10].get());
		assertEquals(0, result[11].get());

	}

}
