/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04 {

	public static void main(String[] args) {
		int[] values = { 1, 4, 9, 16 };

		Stream<int[]> stream  = Stream.of(values);

		stream.forEach(i -> System.out.println(i)); //配列のインスタンスが1つ出力される

		IntStream intStream = Arrays.stream(values);

		intStream.forEach(i -> System.out.println(i)); //配列のインスタンスが1つ出力される
	}
}
