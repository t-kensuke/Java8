/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

public class Ex08 {

	public static void main(String[] args) {
		Stream<String> ids = getAvailableIdsStream();
		ids.forEach(s -> {
			ZonedDateTime time = ZonedDateTime.now(ZoneId.of(s));
			System.out.println("Zone:" + s + "  offset:" + time.getOffset());
		}
				);
	}

	public static Stream<String> getAvailableIdsStream() {
		return ZoneId.getAvailableZoneIds().stream();
	}

}
