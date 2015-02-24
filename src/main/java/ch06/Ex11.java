package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex11 {

	public static void main(String[] args) {
		repeat(() -> inputUserInfo(), (userInfo) -> login(userInfo));
	}

	private static boolean login(PasswordAuthentication userInfo) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return Arrays.equals("secret".toCharArray(), userInfo.getPassword());
	}

	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		CompletableFuture.supplyAsync(action).thenApply(
				(userInfo) -> !until.test(userInfo) ? repeat(action, until) : null);
		return null;
	}

	public static PasswordAuthentication inputUserInfo() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in), 1);

			System.out.print("UserName: ");
			System.out.flush();
			String userName;
			userName = r.readLine();

			System.out.print("Password: ");
			System.out.flush();
			String password = r.readLine();

			return new PasswordAuthentication(userName, password.toCharArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
