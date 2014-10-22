/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch01;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Ex04 {

	/**
	 * ファイルパスをソートする。ディレクトリ優先で並べる
	 *
	 * @param path
	 *            検索するパスを指定する
	 * @param ext
	 *            拡張子を指定する
	 * @return
	 */
	public static void sortFilesLamda(final File[] paths) {
		if (paths == null) {
			throw new IllegalArgumentException("dir must not be null");
		}

		Arrays.sort(paths, (f1, f2) -> {
			if (f1.isDirectory() && f2.isFile()) {
				return -1;
			} else if (f1.isFile() && f2.isDirectory()) {
				return 1;
			} else {
				return f1.compareTo(f2);
			}
		});
	}

	/**
	 * Comparator使用版
	 * @param paths
	 */
	public static void sortFiles(final File[] paths) {
		if (paths == null) {
			throw new IllegalArgumentException("dir must not be null");
		}

		Arrays.sort(paths, new Comparator<File>() {

			@Override
			public int compare(File f1, File f2) {
				if(f1.isDirectory() && f2.isFile()){
					return -1;
				} else if(f1.isFile() && f2.isDirectory()){
					return 1;
				} else {
					return f1.compareTo(f2);
				}
			}
		});
	}


}
