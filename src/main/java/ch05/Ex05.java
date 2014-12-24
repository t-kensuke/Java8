/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Ex05 {

	public static void main(String[] args) {

		System.out.println("生きてきた日数は：" + getToalLivingDays( LocalDate.of(1983, 1, 2)));
	}

	public static long getToalLivingDays(LocalDate birthday){
		return birthday.until(LocalDate.now(), ChronoUnit.DAYS);
	}
}
