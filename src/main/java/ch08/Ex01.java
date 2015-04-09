package ch08;

public class Ex01 {

	/**
	 * diviudeUnsignedとremainderUnsignedが必要な理由：
	 *　
	 */
	public static void main(String[] args) {
		int result = Integer.MAX_VALUE + 1;

		System.out.println(Integer.MAX_VALUE + " + " + 1 + " = " + Integer.toUnsignedLong(result));

		result = 1 - 2;

		System.out.println(1 + " - " + 2 + " = " + Integer.toUnsignedLong(result));

		result = (int) Math.pow(2, 30) / -3;

		System.out.println("2^30" + " / " + 2 + " = " + Integer.toUnsignedLong(result));

		result = Integer.divideUnsigned((int) Math.pow(2, 30), -3);

		System.out.println("2^30" + " / " + 2 + " = " + Integer.toUnsignedLong(result));

		boolean b  = Integer.toUnsignedLong(Integer.MAX_VALUE + 1) > Integer.toUnsignedLong(Integer.MAX_VALUE);

		System.out.println("Integer.MAX_VALUE + 1" + " >  " + "Integer.MAX_VALUE"+ " = " + b);

		b  = Integer.MAX_VALUE + 1 > Integer.MAX_VALUE;

		System.out.println("Integer.MAX_VALUE + 1" + " >  " + "Integer.MAX_VALUE"+ " = " + b);

	}

}
