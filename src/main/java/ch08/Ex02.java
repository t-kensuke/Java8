package ch08;

public class Ex02
{
	public static void main(String[] args) {
		try {
			Math.negateExact(Integer.MIN_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
