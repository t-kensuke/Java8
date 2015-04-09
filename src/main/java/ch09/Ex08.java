package ch09;

import java.io.IOException;
import java.util.Arrays;

public class Ex08 {

	public static void main(String[] args) throws IOException {

		Point[] p = new Point[] { new Point(2, 2), new Point(2, 1), new Point(1, 1) };

		Arrays.sort(p);

		System.out.println("result: " + Arrays.asList(p));

	}

	static class Point implements Comparable<Point> {

		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point p) {
			int comp = Long.compare(x, p.x);

			if (comp != 0) {
				return comp;
			} else {
				return Long.compare(y, p.y);
			}
		}

		@Override
		public String toString() {
			return "Point(" + x + "," + y + ")";
		}

	}
}
