/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ex15 {

	public static class LatentImage {

		private Image in;
		private List<UnaryOperator<Color>> pendingOperations;

		public LatentImage(Image in) {
			pendingOperations = new ArrayList<UnaryOperator<Color>>();
			this.in = in;
		}

		static LatentImage from(Image in) {
			return new LatentImage(in);
		}

		LatentImage transform(UnaryOperator<Color> f) {
			pendingOperations.add(f);
			return this;
		}

		public Image toImage() {

			int width = (int) in.getWidth();
			int height = (int) in.getHeight();

			Color[][] inColors = new Color[height][width];

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					inColors[y][x] = in.getPixelReader().getColor(x, y);
				}
			}

			Color[][] outColors = null;

			for (UnaryOperator<Color> f : pendingOperations) {
				outColors = parallelTransform(inColors, f);
			}

			WritableImage out = new WritableImage(width, height);

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					out.getPixelWriter().setColor(x, y, outColors[y][x]);
				}
			}

			return out;
		}
	}

	private static Color[][] parallelTransform(Color[][] in, UnaryOperator<Color> f) {
		int n = Runtime.getRuntime().availableProcessors();
		int height = in.length;
		int width = in[0].length;
		Color[][] out = new Color[height][width];

		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for (int i = 0; i < n; i++) {
				int fromY = i * height / n;
				int toY = (i + 1) * height / n;
				pool.submit(() -> {
					for (int x = 0; x < width; x++) {
						for (int y = fromY; y < toY; y++) {
							out[y][x] = f.apply(in[y][x]);
						}
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return out;
	}
}
