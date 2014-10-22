/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */

package ch01;

public class Ex07 {

	public static void main(String[] args) {
		Runnable runs = andThen(() -> {
			System.out.println("1");
		}, () -> {
			System.out.println("2");
		});

		new Thread(runs).start();

	}

	/**
	 *二つのRunnableを受け取りそれぞれ順に実行する
	 * @param runner1
	 * @param runner2
	 * @return
	 */
	public static Runnable andThen(Runnable runner1, Runnable runner2) {
		return () -> {
			runner1.run();
			runner2.run();
		};
	}
}
