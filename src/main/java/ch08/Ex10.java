package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex10 {
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("D:/tool/pleiades/eclipse/jre/src");

		try (Stream<Path> stream = Files.walk(dir)) {
			stream.filter(entry -> {
				try (Stream<String> fileStream = Files.lines(entry)) {
					return fileStream.filter(s -> s.contains("transient") || s.contains("valatile")).findFirst().isPresent();
				} catch (IOException e) {
					return false;
				}
			}

					).forEach(System.out::println);
		}
	}

}
