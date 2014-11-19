/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.FileNotFoundException;
import java.util.Arrays;

import junit.framework.TestCase;

public class TestEx07 extends TestCase {

	public void testCompare() throws FileNotFoundException {
		String[] array = new String[]{"cc","bb", "aa"};

		Arrays.sort(array, Ex07.compare());

		assertEquals("aa", array[0]);
		assertEquals("bb", array[1]);
		assertEquals("cc", array[2]);
	}

	public void testCompareIgnoreCaseAndTrim() throws FileNotFoundException {
		String[] array = new String[]{"cc","  BB", " aa"};

		Arrays.sort(array, Ex07.compareIgnoreCaseAndTrim());

		assertEquals(" aa", array[0]);
		assertEquals("  BB", array[1]);
		assertEquals("cc", array[2]);
	}

}
