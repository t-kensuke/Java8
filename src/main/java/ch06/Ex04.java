package ch06;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

public class Ex04 {

	public static long maxValue(LongStream longStream) {

		if (longStream == null) {
			throw new NullPointerException("longStream must not be null.");
		}

		LongAccumulator maxValueAccumulator = new LongAccumulator((x, y) -> {
			if (x >= y) {
				return x;
			} else {
				return y;
			}
		}, Long.MIN_VALUE);

		longStream.forEach(longValue -> maxValueAccumulator
				.accumulate(longValue));

		return maxValueAccumulator.get();
	}

	public static long minValue(LongStream longStream) {

		if (longStream == null) {
			throw new NullPointerException("longStream must not be null.");
		}

		LongAccumulator minValueAccumulator = new LongAccumulator((x, y) -> {
			if (x < y) {
				return x;
			} else {
				return y;
			}
		}, Long.MAX_VALUE);

		longStream.forEach(longValue -> minValueAccumulator
				.accumulate(longValue));

		return minValueAccumulator.get();
	}
}
