package ch01;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class TestEx04 extends TestCase{

	public void testListFilesLamda() throws Exception {
		List<File> files = Ex03.listFiles(new File("src/test/resources/ch01/ex02"), "txt");
		List<File> dirs = Ex02.listDirs(new File("src/test/resources/ch01/ex02"));

		dirs.addAll(files);

		File[] array = (File[])dirs.toArray(new File[0]);

		System.out.println(Arrays.asList(array));

		Ex04.sortFilesLamda(array);

		System.out.println(Arrays.asList(array));
	}

	public void testListFiles() throws Exception {
		List<File> files = Ex03.listFiles(new File("src/test/resources/ch01/ex02"), "txt");
		List<File> dirs = Ex02.listDirs(new File("src/test/resources/ch01/ex02"));

		dirs.addAll(files);

		File[] array = (File[])dirs.toArray(new File[0]);

		System.out.println(Arrays.asList(array));

		Ex04.sortFiles(array);

		System.out.println(Arrays.asList(array));
	}
}