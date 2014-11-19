/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ex08 {

	public static Image transform(Image in, ColorTrasformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in));
			}
		}

		return out;
	}

	@FunctionalInterface
	public interface ColorTrasformer {
		Color apply(int x, int y, Image img);
	}

	public static ColorTrasformer createTransformer(int width, Color color) {
		return (x, y, img) -> {
			if (x < width || img.getWidth() - width <= x || y < width || img.getHeight() - width <= y) {
				return color;
			} else {
				return img.getPixelReader().getColor(x, y);
			}
		};
	}

}
