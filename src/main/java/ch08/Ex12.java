package ch08;

import java.io.IOException;
import java.lang.reflect.Method;

public class Ex12 {
	public static void main(String[] args) throws IOException {
		System.out.println(factorial(4));

		try {
			Method m = Ex12.class.getDeclaredMethod("factorial", int.class);
			TestCase t = m.getAnnotation(TestCase.class);
			if ( t != null && factorial(Integer.parseInt(t.params())) == Long.parseLong(t.expected())) {
				System.out.println("succness!");
			} else {
				System.out.println("fail!");
			}

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}

	@TestCase(params = "4", expected = "24")
	public static long factorial(int n) {
		long fact = 1;
		while (n > 0) {
			fact = fact * n;
			n--;
		}
		return fact;
	}

}
