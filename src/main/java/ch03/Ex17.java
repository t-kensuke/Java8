/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.function.Consumer;

public class Ex17 {

	public static <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {

		Thread t1 = new Thread() {
			public void run() {
				try {
					first.run();
				} catch (Throwable th) {
					handler.accept(th);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				try {
					second.run();
				} catch (Throwable th) {
					handler.accept(th);
				}
			}
		};
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		doInParallelAsync(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("first" + i);
			}
			throw new NullPointerException("throw dummy exception");
		},
				() -> {
					for (int i = 0; i < 10; i++) {
						System.out.println("secnod" + i);
					}
				}
				, (t) -> {
					if (t != null) {
						t.printStackTrace();
					}
				});

	}

}
