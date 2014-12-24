/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;

import junit.framework.TestCase;

public class TestEx03 extends TestCase {

	public void testNextDay() {
		LocalDate date = LocalDate.of(2014, 12, 25);

		LocalDate next = date.with(Ex03.next(w -> w.getDayOfWeek().getValue() < 6 ));

		assertEquals(LocalDate.of(2014, 12, 26), next);
	}

	public void testNextDay2() {
		LocalDate date = LocalDate.of(2014, 12, 26);

		LocalDate next = date.with(Ex03.next(w -> w.getDayOfWeek().getValue() < 6 ));

		assertEquals(LocalDate.of(2014, 12, 29), next);
	}

}
