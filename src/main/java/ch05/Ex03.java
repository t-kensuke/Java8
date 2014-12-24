/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class Ex03 {

	public static TemporalAdjuster next(Predicate<LocalDate> predicate) {

		return w -> {
			LocalDate result = (LocalDate) w;
			do {
				result = result.plusDays(1);

			} while (!predicate.test(result));
			return result;
		};

	}
}
