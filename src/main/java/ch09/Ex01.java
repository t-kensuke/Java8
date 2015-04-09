package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) throws IOException {

		// try-with-resourcesで書いた場合
		//		try (Scanner in = new Scanner(Paths.get("./src/test/java/ch08/Ex16.txt"));
		//				PrintWriter out = new PrintWriter("./src/test/java/ch09/Ex01.txt");) {
		//			while (in.hasNext()) {
		//				System.out.println(in.next().toLowerCase());
		//			}
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}

		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("./src/test/java/ch08/Ex16.txt"));

			out = new PrintWriter("./src/test/java/ch09/Ex01.txt");
			while (in.hasNext()) {
				System.out.println(in.next().toLowerCase());
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}

		}

	}

}
