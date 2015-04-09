package ch09;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Ex10 {

	public static void main(String[] args) throws IOException {

		LabelPoint p1 = new LabelPoint("bb", 1, 1);
		LabelPoint p2 = new LabelPoint(new String("aa"), 2, 1);
		LabelPoint p3 = new LabelPoint("bb", 1, 2);

		LabelPoint[] p = new LabelPoint[] { p1, p2, p3 };

		Arrays.sort(p);

		System.out.println("result: " + Arrays.asList(p));

	}

	static class LabelPoint implements Comparable<LabelPoint> {

		private String label;
		private int x;
		private int y;

		public LabelPoint(String label, int x, int y) {
			this.label = label;
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			LabelPoint other = (LabelPoint) obj;

			return Objects.equals(label, other.label) && Objects.equals(x, other.x) && Objects.equals(y, other.y);
		}

		@Override
		public int hashCode() {
			return Objects.hash(label, x, y);
		}

		@Override
		public String toString() {
			return "Point(" + label + "," + x + "," + y + ")";
		}

		@Override
		public int compareTo(LabelPoint p) {

			int comp = label.compareTo(p.label);

			if (comp != 0) {
				return comp;
			} else {
				comp = Long.compare(x, p.x);

				if (comp != 0) {
					return comp;
				} else {
					return Long.compare(y, p.y);
				}
			}
		}

	}
}
