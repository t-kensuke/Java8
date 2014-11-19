/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.Comparator;

public class Ex07 {

	/**
	 * 普通, 大文字小文字を区別、空白を含める
	 */
	public static Comparator<String> compare(){
		return (str1, str2) -> str1.compareTo(str2);
	}

	/**
	 * 逆順、大文字小文字を区別、空白を含める
	 * @return
	 */
	public static Comparator<String> compareReverse(){
		return (str1, str2) -> str2.compareTo(str1);
	}

	/**
	 * 普通, 大文字小文字を区別しない、空白を含める
	 */
	public static Comparator<String> compareIgnoreCase(){
		return (str1, str2) -> str1.compareToIgnoreCase(str2);
	}

	/**
	 * 逆順、大文字小文字を区別しない、空白を含める
	 * @return
	 */
	public static Comparator<String> compareReverseIngoreCase(){
		return (str1, str2) -> str2.compareToIgnoreCase(str1);
	}

	/**
	 * 普通, 大文字小文字を区別しない、空白を除外
	 */
	public static Comparator<String> compareIgnoreCaseAndTrim(){
		return (str1, str2) -> str1.trim().compareToIgnoreCase(str2.trim());
	}

}
