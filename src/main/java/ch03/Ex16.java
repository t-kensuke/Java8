/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Ex16 {

	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {

		Thread t = new Thread() {
			public void run() {
				try {
					T result = first.get();
					second.accept(result, null);
				} catch (Throwable th) {
					second.accept(null, th);
				}
			}
		};
		t.start();
	}

	public static void main(String[] args) {
		doInOrderAsync(() -> {
			if (args != null && args[0] != null) {
				return args[0];
			} else {
				throw new NullPointerException();
			}
		}
				, (a, t) -> {
					if (a != null) {
						System.out.println(a);
					}
					if (t != null) {
						t.printStackTrace();
					}
				});

	}

}
