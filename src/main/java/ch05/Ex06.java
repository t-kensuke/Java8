/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;

public class Ex06 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1901, 1, 1);
		for (; date.getYear() < 2000;) {
			date = date.with(Ex03.next(w -> (w.getDayOfWeek().getValue() == 5 && w.getDayOfMonth() == 13)));
			System.out.println(date);
		}
	}
}
