package ch08;

import java.util.Arrays;
import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Ex06 {
	public static void main(String[] args) {
		Point2D[] array = new Point2D[]{new Point2D(2,2), new Point2D(1,1), new Point2D(1,0)};
		Arrays.sort(array, new Point2DComparator());
		System.out.println("result: " + Arrays.asList(array));

		Rectangle2D[] array2 = new Rectangle2D[]{new Rectangle2D(2,2,3,3), new Rectangle2D(1,1,3,3), new Rectangle2D(1,0,3,3)};
		Arrays.sort(array2, new Rectangle2DComparator());
		System.out.println("result: " + Arrays.asList(array2));

	}

	static class Point2DComparator implements Comparator<Point2D> {

		public int compare(Point2D p1, Point2D p2) {
			double diffX = p1.getX() - p2.getX();
			if (diffX != 0) {
				return (int) diffX;
			} else {
				return (int) (p1.getY() - p2.getY());
			}
		}
	}

	static class Rectangle2DComparator implements Comparator<Rectangle2D> {

		public int compare(Rectangle2D r1, Rectangle2D r2) {

			double diffX = r1.getMinX() - r2.getMinX();
			if (diffX != 0) {
				return (int) diffX;
			} else {
				return (int) (r1.getMinY() - r2.getMinY());
			}
		}
	}

}
