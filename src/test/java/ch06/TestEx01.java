/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.util.concurrent.atomic.AtomicReference;

import junit.framework.TestCase;

public class TestEx01 extends TestCase {

	public void testLongetString() throws InterruptedException {

		for (int i = 0; i < 10000; i++) {
			final AtomicReference<String> longestString = new AtomicReference<>("1");

			ExThread1 thread2 = new ExThread1(longestString, "333");
			ExThread1 thread1 = new ExThread1(longestString, "22");

			thread1.start();
			thread2.start();

			thread1.join();
			thread2.join();

			assertEquals("333", longestString.get());
		}
	}

	class ExThread1 extends Thread {

		String string;
		AtomicReference<String> longestString;

		public ExThread1(AtomicReference<String> longestString, String string) {
			this.longestString = longestString;
			this.string = string;
		}

		public void run() {
			Ex01.longestString(longestString, string);
		}
	}
}
