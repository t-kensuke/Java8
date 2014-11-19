/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Ex21 {

	public static <T, U> Future<U> map(Future<T> future, Function<T, U> f) {
		if (future == null || f == null) {
			throw new IllegalArgumentException("future or f must not be null");
		}

		return new Future<U>() {

			@Override
			public boolean cancel(boolean arg0) {
				return future.cancel(arg0);
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return f.apply(future.get());
			}

			@Override
			public U get(long arg0, TimeUnit arg1) throws InterruptedException, ExecutionException, TimeoutException {
				return f.apply(future.get(arg0, arg1));
			}

			@Override
			public boolean isCancelled() {
				return future.isCancelled();
			}

			@Override
			public boolean isDone() {
				return future.isDone();
			}
		};
	}
}
