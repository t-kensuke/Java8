package ch02;

import java.util.stream.Stream;

import junit.framework.TestCase;

public class TestEx06 extends TestCase{

	public void testRand() throws Exception {

		Stream<Character> charStream = Ex06.characterStream("abc");

		charStream.forEach(c -> System.out.println(c));

	}
}
