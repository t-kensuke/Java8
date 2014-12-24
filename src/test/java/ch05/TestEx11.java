/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import junit.framework.TestCase;

public class TestEx11 extends TestCase {

	public void testGetArrivalTime() {
		ZonedDateTime frankfurt = ZonedDateTime.of(2014, 12, 1, 14, 5, 0, 0, ZoneId.of("Europe/Berlin"));
		ZonedDateTime losAngeles = ZonedDateTime.of(2014, 12, 1, 16, 40, 0, 0, ZoneId.of("America/Los_Angeles"));
		Duration duration = Duration.ofMinutes(11 * 60 + 35);
		assertEquals(duration, Ex11.getDration(frankfurt, losAngeles));
	}
}
