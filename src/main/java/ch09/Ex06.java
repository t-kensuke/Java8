package ch09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Ex06 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("./src/test/java/ch09/Ex05.txt"));
		Collections.reverse(lines);

		Files.write(Paths.get("./src/test/java/ch09/Ex06_out.txt"), lines);
	}
}
