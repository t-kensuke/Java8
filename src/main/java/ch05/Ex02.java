/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch05;

import java.time.LocalDate;
import java.time.Period;

public class Ex02 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2000, 2, 29);

		System.out.println("1:" + date);
		date = date.plusYears(1);

		//2002-02-28
		System.out.println("1年を加算:" +  date.plusYears(1));

		System.out.println("4年を加算:" +  date.plusYears(4));
		System.out.println("4年を加算:" +  date.plus(Period.ofYears(4)));

		System.out.println("1年を4回加算:" +  date.plusYears(1).plusYears(1).plusYears(1).plusYears(1));

	}

}
