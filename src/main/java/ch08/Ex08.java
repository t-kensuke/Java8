package ch08;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ex08 {
	public static void main(String[] args) {
		Queue queue = new LinkedList<>();

		queue = Collections.checkedQueue(queue, String.class);

		queue.add("aaaa");

		//11行目があれば、例外で検出できる
		queue.add(1);

	}

}
