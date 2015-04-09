package ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> words = Arrays.asList(new String[] { "aa", "b", "ccc",
				"dddd", "ee", "ffffffffffffff", "gggggggggggggggggg" });

		long start = System.currentTimeMillis();
		long result = words.stream().filter(w -> w.length() > 12).count();
		System.out.println("Stream: " + (System.currentTimeMillis() - start));

		List<String> words2 = new ArrayList<>(words);
		start = System.currentTimeMillis();
		words2.removeIf(w -> !(w.length() > 12));
		result = words2.size();
		System.out.println("removeIf: " + (System.currentTimeMillis() - start));
	}

}
