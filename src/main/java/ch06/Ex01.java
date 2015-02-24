/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch06;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

public class Ex01 {

	public static String longestString(AtomicReference<String> observed, String word) {
		return observed.accumulateAndGet(word,
				BinaryOperator.maxBy((str1, str2) -> str1.length() - str2.length()));

	}
}
