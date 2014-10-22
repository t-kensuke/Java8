package ch01;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

public class TestEx03 extends TestCase{

	public void testListFiles() throws Exception {
		List<File> dirs = Ex03.listFiles(new File("src/test/resources/ch01/ex02"), "txt");

		for (File file : dirs) {
			System.out.println(file);
		}
		assertEquals("src\\test\\resources\\ch01\\ex02\\aa\\aa.txt", dirs.get(0).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\bb\\bb.txt", dirs.get(1).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\aa\\cc\\cc.txt", dirs.get(2).getPath());
	}


	public void testListFilesLamda() throws Exception {
		List<File> dirs = Ex03.listFilesLambda(new File("src/test/resources/ch01/ex02"), "txt");

		for (File file : dirs) {
			System.out.println(file);
		}
		assertEquals("src\\test\\resources\\ch01\\ex02\\aa\\aa.txt", dirs.get(0).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\bb\\bb.txt", dirs.get(1).getPath());
		assertEquals("src\\test\\resources\\ch01\\ex02\\aa\\cc\\cc.txt", dirs.get(2).getPath());
	}}
