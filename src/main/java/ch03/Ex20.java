/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Ex20 {

	public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
		if (list == null || f == null) {
			throw new IllegalArgumentException("list or f must not be null");
		}

		List<U> result = new ArrayList<U>();
		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			result.add(f.apply(iterator.next()));
		}
		return result;
	}
}
