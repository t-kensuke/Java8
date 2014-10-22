/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.Arrays;
import java.util.List;

public class Ex10 {

	public static void main(String[] args) {

		List<Double> list = Arrays.asList(new Double(1.0), new Double(2.0), new Double(3.0));

		Double d = list.stream().reduce((i, t) -> i + t).get();
		long count = list.stream().count();

		System.out.println("ave:"+ d/count);
	}
}
