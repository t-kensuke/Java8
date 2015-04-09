package ch09;

import java.io.IOException;
import java.nio.file.Paths;

public class Ex11 {

	public static void main(String[] args) throws IOException, InterruptedException {

		ProcessBuilder builder = new ProcessBuilder("grep", "-r", "^((4¥d{3})|(5[1-5]¥d{2})|(6011))([- ])?¥d{4}([- ])?¥d{4}([- ])?¥d{4}|3[4,7]¥d{13}$", System.getenv("HOME"));
		builder.redirectOutput(Paths.get("./src/test/java/ch09/Ex11_out.txt").toFile());

		Process process = builder.start();
		process.waitFor();

	}

}
