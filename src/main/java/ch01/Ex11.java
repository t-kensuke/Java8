/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */

package ch01;

public class Ex11 {

	/* @fomatter:off
	 * I 抽象、J 抽象 -> 実行可。 Aでfを実装する必要あり。
	 * I 抽象、J デフォルト -> Aのfが実行される。Aでfを実装する必要あり。
	 * I 抽象、J static -> Aのfが実行される。Aでfを実装する必要あり。
	 *
	 * I デフォルト、J 抽象 -> コンパイルできない
	 * I デフォルト、J デフォルト -> コンパイルできない
	 * I デフォルト、J static -> Aでfを実装する必要なし。A.fが実装されない場合、Iのfが実行される
	 *
	 * I static、J 抽象 -> Aでfを実装する必要あり。Aのfが実行される。
	 * I static、J デフォルト -> Aでfを実装する必要なし。A.fが実装されない場合、Iのfが実行される
	 * I static、J static -> Aのfを実装しないと実行できない。実装するとAのfが呼ばれる
	 *@fomatter:on
	 */

	public static void main(String[] args) {
		A a = new A();

		a.f();

		B b = new B();

		b.f();

	}

	static class A implements I, J {

		public void f() {
			System.out.println("default f of A");

		}
	}

	interface I {
		abstract void f();
		//		{
		//			System.out.println("default f of I");
		//		}
	}

	interface J {
		static void f()
		{
			System.out.println("static f of J");
		}
	}

	/*
	 * I 抽象 -> Bで実装しない場合、コンパイルできない。Bで実装した場合Bのfが呼ばれる
	 * I デフォルト ->  Bで実装しない場合、コンパイルできない。Bで実装した場合Bのfが呼ばれる
	 * I static -> Bで実装しない場合、Sのfが実行される。Bで実装した場合Bのfが呼ばれる
	 *
	 */
	static class B extends S implements I {

		public void f() {
			System.out.println("default f of B");

		}
	}

	static class S {
		void f() {
			System.out.println("static f of S");
		}
	}

}
