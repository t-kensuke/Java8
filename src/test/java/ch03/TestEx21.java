/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import junit.framework.TestCase;

public class TestEx21 extends TestCase {

	public void testMap() throws IOException {
		Callable<String> task = new SumTask(" AAAbbbcc");

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> future = executor.submit(task);

		try {
			assertEquals(" aaabbbcc", future.get());

			Future<String> future2 = Ex21.map(future, (x) -> x.trim());

			assertEquals("aaabbbcc", future2.get());
		} catch (InterruptedException e) {
			fail();
			e.printStackTrace();
		} catch (ExecutionException e) {
			fail();
			e.printStackTrace();
		}
	}

	static class SumTask implements Callable<String> {
		String str;

		public SumTask(String str) {
			this.str = str;
		}

		public String call() {
			return str.toLowerCase();
		}
	}

}
