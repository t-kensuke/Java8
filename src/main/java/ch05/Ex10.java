/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex10 {

	public static ZonedDateTime getArrivalTime(ZonedDateTime departures, Duration duration, ZoneId zoneid) {
		return ZonedDateTime.of (departures.plus(duration).toLocalDateTime(), zoneid);

	}

}
