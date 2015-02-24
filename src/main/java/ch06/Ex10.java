package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10 {

	public static void main(String[] args) {

		String url = "http://horstmann.com";
		CompletableFuture.supplyAsync(() -> blockingReadPalge(url)).thenApply(
				(doc) -> getLinks(doc)).thenAccept(System.out::println);

		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}

	/**
	 * @param documentElement
	 * @return
	 */
	private static List<String> getLinks(String html) {

		Pattern pattern = Pattern.compile("<a href=\"([^\"]+)\">", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(html);
		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group(1));
		}

		return list;
	}

	private static String blockingReadPalge(String urlString) {
		// URLを作成してGET通信を行う
		URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.connect();

			// サーバーからのレスポンスを標準出力へ出す
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String xml = "", line = "";
			while ((line = reader.readLine()) != null)
				xml += line;
			System.out.println(xml);
			reader.close();
			return xml;
		} catch (IOException e) {
			e.printStackTrace();
			//throw e;
			return null;
		}
	}
}
