/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch01;

import java.util.concurrent.Callable;

public class Ex06 {

	public static void main(String[] args) {
		new Thread(uncheck(() -> {
			System.out.println("zzz");
			Thread.sleep(1000);
		})).start();

	}

	public static Runnable uncheck(Ex06RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	/**
	 * 以下のメソッドでは適用できない
	 */
	public static Runnable uncheckCallable(Callable runner) {
		return () -> {
			try {
				runner.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
