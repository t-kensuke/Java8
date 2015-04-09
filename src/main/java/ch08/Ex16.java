package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ex16 {
	public static void main(String[] args) throws IOException {
		Pattern pattern = Pattern.compile("(?<city>[a-zA-Z\\P{L} ]+),\\s*(?<state>[A-Z]{2}),\\s*(?<zipcode>[0-9]{5}|[0-9]{9})$");
		Predicate<String> predicate = pattern.asPredicate();

		try (Stream<String> stream = Files.lines(Paths.get("./src/test/java/ch08/Ex16.txt"))) {
			stream.forEach(line -> {
				Matcher m = pattern.matcher(line);
				if (m.find()) {
					System.out.println("line -> " + line);
					String city = m.group("city");
					System.out.println("city: " + city);
					String state = m.group("state");
					System.out.println("state: " + state);
					String zipcode = m.group("zipcode");
					System.out.println("zipcode: " + zipcode);
				}
			});
		}

	}
}
