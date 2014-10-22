/**
 * Copyright 2014 R.  All Rights Reserved.
 */
package ch01;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02 {

	/**
	 * サブディレクトリを含むすべてのディレクトリを返す
	 * @param dir 検索するパスを指定する
	 * @return
	 */
	public static List<File> listDirs(final File dir) {
		if (dir == null) {
			throw new IllegalArgumentException("dir must not be null");
		}

		File[] dirs = dir.listFiles((file) -> file.isDirectory());

		if (dirs == null) {
			return null;
		}

		List<File> result = new ArrayList<File>(Arrays.asList(dirs));

		for (File file : dirs) {
			List<File> subs = listDirs(file);
			if (subs != null) {
				result.addAll(subs);
			}
		}

		return result;

	}

	/**
	 * メソッド参照を利用したもの
	 * @param dir
	 * @return
	 */
	public static List<File> listDirsMethodRef(final File dir) {
		if (dir == null) {
			throw new IllegalArgumentException("dir must not be null");
		}

		File[] dirs = dir.listFiles(File::isDirectory);

		if (dirs == null) {
			return null;
		}

		List<File> result = new ArrayList<File>(Arrays.asList(dirs));

		for (File file : dirs) {
			List<File> subs = listDirs(file);
			if (subs != null) {
				result.addAll(subs);
			}
		}

		return result;

	}

}
