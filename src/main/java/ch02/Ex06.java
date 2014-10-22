/**
 * Copyright 2014 R.  All Rights Reserved.
 */
package ch02;

import java.util.stream.Stream;

public class Ex06 {

	/**
	 * 引数に指定された値の文字ストリームを作成する
	 * @param s 作成したい文字ストリーム
	 * @return 文字ストリーム
	 */
	public static Stream<Character> characterStream(String s) {
		return Stream.iterate(0, n -> n + 1).limit(s.length()).map(i -> s.charAt(i));
	}
}
