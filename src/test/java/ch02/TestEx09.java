package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import junit.framework.TestCase;

public class TestEx09 extends TestCase {

	public void testReduce1() throws Exception {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("c");
		list2.add("d");

		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("e");
		list3.add("f");

		ArrayList[] array = { list1, list2, list3 };

		Stream<ArrayList<String>> stream1 = Arrays.stream(array);
		System.out.println(Ex09.reduceList(stream1));

	}

	public void testReduce2() throws Exception {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("c");
		list2.add("d");

		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("e");
		list3.add("f");

		ArrayList[] array = { list1, list2, list3 };

		Stream<ArrayList<String>> stream2 = Arrays.stream(array);
		System.out.println(Ex09.reduceList2(stream2));

	}

	public void testReduce3() throws Exception {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("c");
		list2.add("d");

		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("e");
		list3.add("f");

		ArrayList[] array = { list1, list2, list3 };

		Stream<ArrayList<String>> stream3 = Arrays.stream(array);
		System.out.println(Ex09.reduceList3(stream3));

	}
}
