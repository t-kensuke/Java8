/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Ex12 {
	public static AtomicInteger[] countWords(Stream<String> words) {

		AtomicInteger[] shortWords = new AtomicInteger[12];

		for (int i = 0; i < shortWords.length; i++)
			shortWords[i] = new AtomicInteger();

		words.parallel().forEach(
				s -> {
					if (s.length() < 12)
						shortWords[s.length() - 1].getAndIncrement();
				});

		return shortWords;

	}
}
