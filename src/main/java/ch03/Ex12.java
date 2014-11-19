/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ch03.Ex05.ColorTrasformer;

public class Ex12 {

	public static class LatentImage {

		private Image in;
		private List<ColorTrasformer> pendingOperations;

		public LatentImage(Image in) {
			pendingOperations = new ArrayList<Ex05.ColorTrasformer>();
			this.in = in;
		}

		static LatentImage from(Image in) {
			return new LatentImage(in);
		}

		LatentImage transform(UnaryOperator<Color> f) {
			pendingOperations.add(Ex11.convert(f));
			return this;
		}

		LatentImage transform(ColorTrasformer f) {
			pendingOperations.add(f);
			return this;
		}

		public Image toImage() {
			int width = (int) in.getWidth();
			int height = (int) in.getHeight();
			WritableImage out = new WritableImage(width, height);

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					Color c = in.getPixelReader().getColor(x, y);
					for (ColorTrasformer f : pendingOperations) {
						c = f.apply(x, y, c);
					}
					out.getPixelWriter().setColor(x, y, c);
				}
			}
			return out;
		}
	}



}
