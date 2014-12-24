/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

public class Ex09 {

	public static void main(String[] args) {
		Stream<String> ids = getAvailableIdsStream();
		ids.forEach(s -> {
			ZonedDateTime time = ZonedDateTime.now(ZoneId.of(s));
			//			ZonedDateTime time = ZonedDateTime.of(2014, 8, 1, 10, 0, 0, 0, ZoneId.of(s));
			ZoneOffset offset = time.getOffset();
			if (offset.getTotalSeconds() % (60 * 60) != 0) {
				System.out.println("Found: Zone:" + s + "  offset:" + time.getOffset());
			}
		}
				);
	}

	public static Stream<String> getAvailableIdsStream() {
		return ZoneId.getAvailableZoneIds().stream();
	}

}
