package ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex09 {

	public static List fibonacci(int size) {

		Matrix[] values = new Matrix[size];
		Arrays.parallelSetAll(values, i -> new Matrix(1, 1, 1, 0));

		Arrays.parallelPrefix(values, (x, y) -> x.multi(y));

		List result = new ArrayList();
		result.add(Long.valueOf(1));
		for (int i = 0; i < size; i++) {
			System.out.println(i + ":" + values[i].a);
			result.add(Long.valueOf(values[i].a));
		}

		return result;
	}

	public static class Matrix {

		int a, b;
		int c, d;

		public Matrix(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		Matrix multi(Matrix val) {
			return new Matrix(a * val.a + b * val.c, b * val.a + d * val.c, c * val.a + d * val.c, c * val.b + d
					* val.d);
		}
	}
}
