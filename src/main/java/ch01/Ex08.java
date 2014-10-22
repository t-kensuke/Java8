/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch01;

import java.util.ArrayList;
import java.util.List;

public class Ex08 {

	public static void main(String[] args) {

		String[] names = { "Peter", "Paul", "Mary" };

		// ラムダ式
		List<Runnable> runners = new ArrayList<>();

		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}

		for (Runnable runner : runners) {
			new Thread(runner).start();
		}

		// 従来方式
		List<Runnable> runners2 = new ArrayList<>();

		for (int i = 0; i < names.length; i++) {
			//iを参照できない
			//			runners.add(() -> System.out.println(names[i]));
		}

		for (Runnable runner : runners2) {
			new Thread(runner).start();
		}
	}
}
