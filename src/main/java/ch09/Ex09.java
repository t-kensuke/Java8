package ch09;

import java.io.IOException;
import java.util.Objects;

public class Ex09 {

	public static void main(String[] args) throws IOException {

		LabelPoint p1 = new LabelPoint("aa", 1, 1);
		LabelPoint p2 = new LabelPoint(new String("aa"), 1, 1);

		System.out.println("result: " + p1.equals(p2));

	}

	static class LabelPoint {

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
			return "Point(" + x + "," + y + ")";
		}

	}
}
