package ch01;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

public class TestEx02 extends TestCase{

	public void testListFiles() throws Exception {
		List<File> dirs = Ex02.listDirs(new File("src/test/resources/ch01/ex02"));

		for (File file : dirs) {
			System.out.println(file);
		}

		assertEquals("src\\test\\resources\\ch01\\ex02\\aa", dirs.get(0).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\bb", dirs.get(1).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\aa\\cc", dirs.get(2).getPath());

	}

	public void testListFiles2() throws Exception {
		List<File> dirs = Ex02.listDirsMethodRef(new File("src/test/resources/ch01/ex02"));

		for (File file : dirs) {
			System.out.println(file);
		}

		assertEquals("src\\test\\resources\\ch01\\ex02\\aa", dirs.get(0).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\bb", dirs.get(1).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\aa\\cc", dirs.get(2).getPath());

	}
}
