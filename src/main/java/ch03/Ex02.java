/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kensuke
 *
 */
public class Ex02 {

	public static void withLock(ReentrantLock lock, Runnable run) {
		if(lock == null || run == null){
			throw new IllegalArgumentException("lock or run must not be null.");
		}

		lock.lock();
		try {
			run.run();
		} finally {
			lock.unlock();
		}
	}

}
