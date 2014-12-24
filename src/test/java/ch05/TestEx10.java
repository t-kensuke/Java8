/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import junit.framework.TestCase;

public class TestEx10 extends TestCase {

	public void testGetArrivalTime() {
		ZonedDateTime losAngeles = ZonedDateTime.of(2014, 12, 1, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
		ZonedDateTime Frankfurt = Ex10.getArrivalTime(losAngeles, Duration.ofMinutes(10 * 60 + 50),
				ZoneId.of("Europe/Berlin"));

		assertEquals(ZonedDateTime.of(2014, 12, 1, 13, 55, 0, 0, ZoneId.of("Europe/Berlin")), Frankfurt);
	}
}
