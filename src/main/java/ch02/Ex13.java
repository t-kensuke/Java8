/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex13 {


	/**
	 * 長さが２以上の数を数える
	 * @param words
	 * @return
	 */
	public static Map<Integer, Long> countWords(Stream<String> words) {

		return words.collect(Collectors.groupingBy(n -> n.length(), Collectors.counting()));

	}
}
