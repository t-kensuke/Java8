/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Ex11 {

	public static Duration getDration(ZonedDateTime arrival, ZonedDateTime departures) {
		return Duration.between(arrival, departures);

	}

}
