package ch06;

import java.util.Arrays;

public class Ex08 {

	public static void main(String[] args) {

		// 配列の生成
		for (int i = 1; i < 10000; i++) {
			int[] array = new int[i];

			for (int j = 0; j < i; j++) {
				array[j] = i;
			}

			long start;

			start = System.currentTimeMillis();
			Arrays.parallelSort(array);
			long parallelSortTime = System.currentTimeMillis() - start;

			start = System.currentTimeMillis();
			Arrays.sort(array);
			long sortTime = System.currentTimeMillis() - start;

			if (parallelSortTime < sortTime) {
				System.out.println(i + "でparallelSortの方がはやくなる");
				break;
			}
		}



	}
}
