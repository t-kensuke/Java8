/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ex13 {

	public static class LatentImage {

		private Image in;
		private List<ImageFilter> pendingOperations;

		public LatentImage(Image in) {
			pendingOperations = new ArrayList<ImageFilter>();
			this.in = in;
		}

		static LatentImage from(Image in) {
			return new LatentImage(in);
		}

		LatentImage transform(ImageFilter f) {
			pendingOperations.add(f);
			return this;
		}

		public Image toImage() {
			int width = (int) in.getWidth();
			int height = (int) in.getHeight();
			WritableImage out = new WritableImage(width, height);
			Image tmp = in;

			for (ImageFilter f : pendingOperations) {
				out = new WritableImage(width, height);
				for (int x = 0; x < width; x++) {

					for (int y = 0; y < height; y++) {

						out.getPixelWriter().setColor(x, y, f.apply(x, y, tmp));
					}
				}

				tmp = out;
			}
			return out;
		}
	}

	@FunctionalInterface
	public interface ImageFilter {
		Color apply(int x, int y, Image img);
	}

}
