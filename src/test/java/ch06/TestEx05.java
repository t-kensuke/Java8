/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.io.File;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

public class TestEx05 extends TestCase {

	public void testCountWords() {
		Map<String, Set<File>> result = Ex05.countWords(new File("./src/test/resources/ch06"), "txt");

		for (Map.Entry entry : result.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}

		assertEquals(6, result.size());

		assertEquals(2, result.get("a").size());
		assertTrue(result.get("a").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test1.txt")));
		assertTrue(result.get("a").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test2.txt")));

		assertEquals(2, result.get("bb").size());
		assertTrue(result.get("bb").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test1.txt")));
		assertTrue(result.get("bb").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test2.txt")));

		assertEquals(2, result.get("ccc").size());
		assertTrue(result.get("ccc").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test1.txt")));
		assertTrue(result.get("ccc").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test2.txt")));

		assertEquals(2, result.get("ddd").size());
		assertTrue(result.get("ddd").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test1.txt")));
		assertTrue(result.get("ddd").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test2.txt")));

		assertEquals(1, result.get("ee").size());
		assertTrue(result.get("ee").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test2.txt")));

		assertEquals(1, result.get("fff").size());
		assertTrue(result.get("fff").contains(new File(".\\src\\test\\resources\\ch06\\ex05\\test2.txt")));

	}

	public void testAllSrc() {
//		Map<String, Set<File>> result = Ex05.countWords(new File("./src/main/java"), "java");

//		for (Map.Entry entry : result.entrySet()) {
//			System.out.println("key: " + entry.getKey());
//			System.out.println("value: " + entry.getValue());
//		}
	}


}
