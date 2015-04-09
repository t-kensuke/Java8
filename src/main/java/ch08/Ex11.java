package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class Ex11 {
	public static void main(String[] args) throws IOException {

		URL url = new URL("http://localhost:8080/hello"); //jetty7で起動
		URLConnection connection = url.openConnection();
		Base64.Encoder encoder = Base64.getEncoder();
		String realm = encoder.encodeToString("plain:plain".getBytes());
		connection.setRequestProperty("Authorization", "Basic " + realm);
		connection.connect();

		try (InputStream in = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			System.out.println(sb.toString());
		}
	}

}
