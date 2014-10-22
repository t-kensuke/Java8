/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03 {

	/**
	 * 指定された拡張子を含むファイルをを検索する
	 *
	 * @param path
	 *            検索するパスを指定する
	 * @param ext
	 *            拡張子を指定する
	 * @return
	 */
	public static List<File> listFilesLambda(final File path, final String ext) {
		if (path == null) {
			throw new IllegalArgumentException("dir must not be null");
		}

		// ディレクトリをすべて取得する
		List<File> dirs = Ex02.listDirs(path);

		List<File> result = new ArrayList<File>();

		// 取得したディレクトリ内のファイルを検索
		for (File target : dirs) {
			File[] files = target.listFiles((dir, name) -> name.endsWith("." + ext));
			result.addAll(Arrays.asList(files));
		}

		return result;
	}

	public static List<File> listFiles(final File path, final String ext) {
		if (path == null) {
			throw new IllegalArgumentException("dir must not be null");
		}

		// ディレクトリをすべて取得する
		List<File> dirs = Ex02.listDirs(path);

		List<File> result = new ArrayList<File>();

		// 取得したディレクトリ内のファイルを検索
		for (File target : dirs) {
			File[] files = target.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith("." + ext);
				}

			});
			result.addAll(Arrays.asList(files));
		}

		return result;
	}

}
