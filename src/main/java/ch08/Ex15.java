package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ex15 {
	public static void main(String[] args) throws IOException {
		Pattern pattern = Pattern.compile(".*main.*");
		Predicate<String> predicate = pattern.asPredicate();

		try (Stream<String> stream = Files.lines(Paths.get("./src/main/java/ch08/Ex15.java"))) {
			stream.filter(line -> predicate.test(line)).forEach(System.out::println);
		}
	}

}
