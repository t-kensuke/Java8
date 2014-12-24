/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex12 {

	public static void main(String[] args) {

		// 予定１ニューヨークで午前１０時に会議
		ZonedDateTime losAngeles = ZonedDateTime.of(2014, 12, 1, 10, 0, 0, 0, ZoneId.of("America/New_York"));

		System.out.println(losAngeles+ "の予定は" + getNofityTime(losAngeles) +"に通知される");
		getNofityTime(losAngeles);

	}

	public static ZonedDateTime getNofityTime(ZonedDateTime scudule){
		return ZonedDateTime.of (scudule.minus(Duration.ofHours(1)).toLocalDateTime(), ZoneId.systemDefault());
	}

}
