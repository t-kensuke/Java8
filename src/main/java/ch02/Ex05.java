/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.stream.Stream;

public class Ex05 {

	public static Stream<Long> createRandStream(long a, long c, long m, long seed) {
		return Stream.iterate(seed, x -> (a * x + c) % m);

	}
}
