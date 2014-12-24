/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import junit.framework.TestCase;
import ch05.Ex07.TimeInterval;

public class TestEx07 extends TestCase {

	public void testTimeInterval() {
		ZonedDateTime date1 = ZonedDateTime.of(2014, 12, 25, 10, 00, 00, 0, ZoneId.systemDefault());
		ZonedDateTime date2 = ZonedDateTime.of(2014, 12, 25, 12, 00, 00, 0, ZoneId.systemDefault());

		TimeInterval timeInterval1 = new TimeInterval(date1, date2);

		ZonedDateTime date3 = ZonedDateTime.of(2014, 12, 25, 12, 00, 00, 0, ZoneId.systemDefault());
		ZonedDateTime date4 = ZonedDateTime.of(2014, 12, 25, 13, 00, 00, 0, ZoneId.systemDefault());

		TimeInterval timeInterval2 = new TimeInterval(date3, date4);
		TimeInterval.isOverlap(timeInterval1, timeInterval2);
		assertTrue(TimeInterval.isOverlap(timeInterval1, timeInterval2));
	}

}
