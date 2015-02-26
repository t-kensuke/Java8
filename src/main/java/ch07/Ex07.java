package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex07 {


	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping");
		Process process = pb.start();

		int ret = process.waitFor();
		System.out.println("戻り値：" + ret);
		InputStream is = process.getInputStream();	//標準出力
		printInputStream(is);
	}

	public static void printInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			for (;;) {
				String line = br.readLine();
				if (line == null) break;
				System.out.println(line);
			}
		} finally {
			br.close();
		}
	}
}
