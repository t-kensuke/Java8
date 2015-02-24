package ch06;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Ex07 {

	public static String getKeyOfMaxValue(ConcurrentHashMap<String, Long> map) {

		Entry<String, Long> e =  map.reduceEntries(10, (a, b) -> {

			if (a.getValue() > b.getValue()) {
				return a;
			} else {
				return b;
			}
		});

		return e.getKey();
	}
}
