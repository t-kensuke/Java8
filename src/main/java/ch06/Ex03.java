/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ex03 {

	public static void main(String[] args) throws InterruptedException {

		Thread[] threads = new Thread[1000];
		long start;

		start = System.currentTimeMillis();
		AtomicLong val1 = new AtomicLong();
		for (int i = 0; i < 1000; i++) {
			threads[i] = new AtomicLongThread(val1);
			threads[i].start();
		}

		for (int i = 0; i < 1000; i++) {
			threads[i].join();
		}
		System.out.println("AtomicLong time: " + (System.currentTimeMillis()- start));

		start = System.currentTimeMillis();
		LongAdder val2 = new LongAdder();
		for (int i = 0; i < 1000; i++) {
			threads[i] = new LongAdderThread(val2);
			threads[i].start();
		}

		for (int i = 0; i < 1000; i++) {
			threads[i].join();
		}
		System.out.println("LongAdder time: " + (System.currentTimeMillis()- start));

	}

	static class AtomicLongThread extends Thread {

		AtomicLong val;

		public AtomicLongThread(AtomicLong val) {
			this.val = val;
		}

		public void run() {
			for (int i = 0; i < 100000; i++) {
				val.incrementAndGet();
			}
		}
	}

	static class LongAdderThread extends Thread {

		LongAdder val;

		public LongAdderThread(LongAdder val) {
			this.val = val;
		}

		public void run() {
			for (int i = 0; i < 100000; i++) {
				val.increment();
			}
		}
	}

}
