/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.lang.reflect.Field;
import java.util.Comparator;

public class Ex09 {

	/**
	 * 普通, 大文字小文字を区別しない、空白を除外
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public static Comparator<Object> lexicographicComparator(String... fieldNames) {

		return (obj1, obj2) -> {
			for (String fieldName : fieldNames) {
				try {
					Field f1 = obj1.getClass().getField(fieldName);
					Object value1 = f1.get(obj1);

					Field f2 = obj2.getClass().getField(fieldName); //フィールド名を指定
					Object value2 = f2.get(obj2);

					if (value1.equals(value2)) {
						continue;
					} else {
						if (value1 instanceof Comparable && value2 instanceof Comparable) {
							return ((Comparable) value1).compareTo((Comparable) value2);
						} else {
							//?
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
			return 0;
		};
	}

}
