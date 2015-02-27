package ch06;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Ex06 {

	public static Map<String, Set<File>> countWords(File dir, String ext) {
		Map<String, Set<File>> mergeResult = new ConcurrentHashMap<String, Set<File>>();
		ExecutorService service = Executors.newFixedThreadPool(3);

		List<File> files = ch01.Ex03.listFilesLambda(dir, ext);

		List<Future> f = new ArrayList<Future>();

		// タスク登録
		files.stream().forEach(file -> {

			f.add(service.submit(new Callable<Map>() {
				@Override
				public Map<String, Set<File>> call() throws Exception {

					String contents = new String(Files.readAllBytes(Paths
							.get(file.getPath())), StandardCharsets.UTF_8);

					String[] words = contents.split("[\\P{L}]+");

					Map<String, Set<File>> result = new HashMap<String, Set<File>>();
					Set<File> val = new HashSet<File>();
					val.add(file);
					Arrays.stream(words).forEach(w -> {
						Set<File> files = mergeResult.putIfAbsent(w, val);
						if(files != null){
							files.add(file);
						}
					});

					return result;
				}

			}));
		});

		// 結果を待つ
//		f.stream().forEach(future -> {
//			try {
//				future.get();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
		service.shutdown();
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return mergeResult;
	}
}
