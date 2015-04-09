package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) throws IOException {

		Scanner in = null;
		PrintWriter out = null;
		Exception tempExp1 = null, tempExp2 = null;
		try {
			in = new Scanner(Paths.get("./src/test/java/ch08/Ex16.txt"));

			out = new PrintWriter("./src/test/java/ch09/Ex01.txt");
			while (in.hasNext()) {
				System.out.println(in.next().toLowerCase());
			}
		} catch (IOException e) {
			if (tempExp1 != null) {
				e.addSuppressed(tempExp1);
			}
			if (tempExp2 != null) {
				e.addSuppressed(tempExp2);
			}
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e1) {
					tempExp1 = e1;
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					tempExp2 = e2;
				}
			}

		}

	}

}
