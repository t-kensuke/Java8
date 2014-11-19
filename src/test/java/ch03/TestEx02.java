/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.concurrent.locks.ReentrantLock;

import junit.framework.TestCase;

public class TestEx02 extends TestCase {

	public void testWithLock() throws Exception {
		ReentrantLock myLock = new ReentrantLock();

		Ex02.withLock(myLock, () -> {
			System.out.println("myLock="+ myLock.isLocked());
		});
	}

}
