/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;
import java.time.Period;

public class Ex01 {

	public static LocalDate calcProgrammersDay() {
		return LocalDate.of(2014, 1,1).plus(Period.ofDays(255));
	}

}
