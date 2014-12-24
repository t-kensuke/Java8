/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;

import junit.framework.TestCase;

public class TestEx01 extends TestCase {

	public void testProgrammerDay() {
		Ex01.calcProgrammersDay().equals(LocalDate.of(2014, 1, 1).plusDays(255));
	}

}
