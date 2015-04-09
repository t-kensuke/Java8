package ch09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex05 {

	public static void main(String[] args) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("./src/test/java/ch09/Ex05.txt"));

	    for (int left = 0, right = bytes.length - 1; left < right; left++, right--) {
	        byte temp = bytes[left];
	        bytes[left]  = bytes[right];
	        bytes[right] = temp;
	    }

		Files.write(Paths.get("./src/test/java/ch09/Ex05_out.txt"), bytes);
	}
}
