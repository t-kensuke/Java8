/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex02 {

	/**
	 * サイズが2以上の文字列を出力する
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] { "aa", "b", "ccc",
				"dddd", "ee", "fffffff", "gggggg" });

		Stream<String> filterStream = list.stream()
				.filter(value -> greaterThan(value, 2)).limit(5);
		filterStream.forEach(e -> System.out.println("str: " + e)); // ggggは出力されない

	}

	private static boolean greaterThan(String str, int length) {
		System.out.println("chcek length:" + str);
		return str.length() >= length;
	}

}
