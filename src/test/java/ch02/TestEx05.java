package ch02;

import java.util.stream.Stream;

import junit.framework.TestCase;

public class TestEx05 extends TestCase{

	public void testRand() throws Exception {

		Stream<Long> longStream = Ex05.createRandStream(25214903917L, 11L, (long) Math.pow(2, 48), 100).limit(100);

		longStream.forEach(n -> System.out.println(n));

	}
}
