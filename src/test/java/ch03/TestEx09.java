package ch03;
/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */


import java.io.IOException;
import java.util.Arrays;

import junit.framework.TestCase;

public class TestEx09 extends TestCase {

	public void testLexicographicComparator() throws IOException {

		Person[] array = new Person[]{new Person("suzuki", "taro"), new Person("suzuki", "jiro")};

		Arrays.sort(array, Ex09.lexicographicComparator("lastname", "firstname"));

		assertEquals("jiro", array[0].firstname);
		assertEquals("taro", array[1].firstname);
	}

	public static class Person {
		public String lastname;
		public String firstname;

		public Person(String lastname, String firstname) {

			this.lastname = lastname;
			this.firstname = firstname;
		}
	}

}
