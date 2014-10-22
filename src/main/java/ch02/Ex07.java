/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch02;

import java.util.stream.Stream;

public class Ex07 {


	/**
	 * 無限のストリームの場合、検査できないため、よい考えではない。
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(isFinite(Stream.iterate(10, i -> i + 10))); //帰ってこない
		System.out.println(isFinite(Stream.iterate(10, i -> i + 10).limit(10))); //ok

	}

	/**
	 * Streamが有限かを調べます。
	 * @param stream
	 * @return true 有限、false無限
	 */
	public static <T> boolean isFinite(Stream<T> stream) {

		return stream.count() >= 0;
	}

}
