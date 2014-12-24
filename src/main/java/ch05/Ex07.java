/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.ZonedDateTime;

public class Ex07 {

	public static class TimeInterval {
		ZonedDateTime begin;
		ZonedDateTime end;

		public TimeInterval(ZonedDateTime date1, ZonedDateTime date2) {
			if (date1.compareTo(date2) > 1) {
				begin = date1;
				end = date2;
			} else {
				begin = date2;
				end = date1;
			}
		}

		public static boolean isOverlap(TimeInterval time1, TimeInterval time2) {

			return (time1.begin.compareTo(time2.begin) >= 0 && time1.end.compareTo(time2.begin) <= 0)
					|| (time1.begin.compareTo(time2.end) >= 0 && time1.end.compareTo(time2.end) <= 0);
		}
	}

}
