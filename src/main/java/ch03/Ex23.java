/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.function.Function;

public class Ex23 {

	public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> f) {
		if (pair == null || f == null) {
			throw new IllegalArgumentException("pair or f must not be null");
		}
		return new Pair<U>(f.apply(pair.value1), f.apply(pair.value2));
	}

	static class Pair<T> {
		T value1, value2;

		public Pair(T value1, T value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
	}
}
