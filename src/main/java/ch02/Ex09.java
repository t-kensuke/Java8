/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Ex09 {

	/**
	 * streamを集約する
	 * パターン１
	 * @param stream
	 * @return
	 */
	static <T> ArrayList<T> reduceList(Stream<ArrayList<T>> stream) {
		return stream.reduce((x, y) -> {
			x.addAll(y);
			return x;
		}).get();
	}

	/**
	 * streamを集約する
	 * パターン２
	 * @param stream
	 * @return
	 */
	static <T> ArrayList<T> reduceList2(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<T>(), (x, y) -> {
			x.addAll(y);
			return x;
		});
	}

	/**
	 * streamを集約する
	 * パターン３
	 * @param stream
	 * @return
	 */
	static <T> ArrayList<T> reduceList3(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<T>(),
				(x, y) -> {
					x.addAll(y);
					return x;
				},
				(x2, y2) -> {
					x2.addAll(y2);
					return x2;
				});
	}

}
