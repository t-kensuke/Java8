package ch07;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ex02 {

	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get(new File(".\\src\\test\\resources\\ch07\\ex02.txt").getPath())), StandardCharsets.UTF_8);
		String[] words = contents.split("[\\P{L}]+");
		Stream<String> result = Arrays.stream(words).filter(w -> w.length() > 12).distinct().sorted();
		result.forEach(System.out::println);
	}
}


