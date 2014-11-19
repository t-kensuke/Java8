/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.logging.Level;

import junit.framework.TestCase;

public class TestEx01 extends TestCase {

	public void testFINESET() throws Exception {

		int[] a = new int[11];
		int i = 10;

		a[10] = 10;
		Ex01.logger.setLevel(Level.FINEST);
		Ex01.logIf(Level.FINEST, () -> i == 10, () -> "a[10]=" + a[10]);

	}

	public void testFINESET2() throws Exception {

		Ex01.logger.setLevel(Level.INFO);
		Ex01.logIf(Level.FINEST, () -> {
			fail();
			return false;
		}, () -> {
			fail();
			return "aaa";
		});

	}

}
