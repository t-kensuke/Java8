/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex04 {

	public static void main(String[] args) {
		args = new String[2];
		args[1] = "2013";
		args[0] = "3";

		LocalDate month = LocalDate.of(Integer.valueOf(args[1]), Integer.valueOf(args[0]), 1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");

		int week = month.getDayOfWeek().getValue();
		int manth = month.getMonthValue();

		System.out.println("Mn Tu We Th Fr St Sn");
		for (int i = 1; i < week; i++) {
			System.out.print("  " + " ");
		}

		for (; manth == month.getMonthValue();) {
			for (int w = week; w <= 7; w++) {
				System.out.print(formatter.format(month) + " ");
				month = month.plusDays(1);
				if (manth != month.getMonthValue()) {
					break;
				}
			}
			System.out.println();
			week = 1;
		}
	}
}
