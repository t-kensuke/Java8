package ch08;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(gcd(390, 273));
		System.out.println(gcdRem(390, 273));
		System.out.println(gcdFloorMod(390, 273));

		System.out.println(gcd(390, -273));
		System.out.println(gcdRem(390, -273));
		System.out.println(gcdFloorMod(390, -273));

	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return Math.abs(gcd(b, a % b));
		}
	}

	static int gcdRem(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return Math.abs(gcdRem(b, rem(a, b)));
		}
	}

	static int gcdFloorMod(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return Math.abs(gcdFloorMod(b, Math.floorMod(a, b)));
		}
	}

	static int rem(int a, int b) {
		return Math.abs(a % b);
	}

}
