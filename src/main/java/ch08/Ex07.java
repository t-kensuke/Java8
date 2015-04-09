package ch08;

import java.util.Arrays;
import java.util.Comparator;

public class Ex07 {
	public static void main(String[] args) {
		Person[] people = new Person[] { new Person("a", "b", "c"),new Person("a", "a", "c") ,new Person("a", "c", "c")  };

//		Arrays.sort(people, Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder()).reversed() ));
		Arrays.sort(people, Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(Comparator.reverseOrder()) ));
		System.out.println("result: " + Arrays.asList(people));

	}

	static class Person {

		String firstName;
		String middleName;
		String lastName;

		public Person(String firstName, String middleName, String lastName) {
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
		}

		String getMiddleName() {
			return middleName;
		}

		public String toString() {
			return firstName + " " + middleName + " " + lastName;
		}
	}

}
