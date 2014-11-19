/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ex05 {

	public static Image transform(Image in, ColorTrasformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}

		return out;
	}

	@FunctionalInterface
	public interface ColorTrasformer {
		Color apply(int x, int y, Color colorAtXY);
	}

	/**
	 * UnaryOperator バージョン
	 * @param in
	 * @param f
	 * @return
	 */
	public static Image transformUnaryOperator(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
}
