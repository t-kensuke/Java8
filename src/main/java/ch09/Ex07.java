package ch09;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex07 {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://www.yahoo.co.jp");
		try (InputStream in = u.openStream()) {
			Files.copy(in, Paths.get("./src/test/java/ch09/Ex07_out.txt"), StandardCopyOption.REPLACE_EXISTING);
		}
	}
}
