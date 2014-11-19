/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

public class TestEx13 extends TestCase {

	public void testTransform() throws IOException {

		Image in = new Image(new FileInputStream("src/test/java/ch03/eiffel-tower.jpg"));

		Image finalImage = Ex13.LatentImage
				.from(in)
				.transform(
						(x, y, img) -> {
							// エッジ
						if (0 < x && x < img.getWidth() - 1 && 0 < y && y < img.getHeight() - 1) {
							double r = img.getPixelReader().getColor(x, y).getRed() * 4
									- img.getPixelReader().getColor(x - 1, y).getRed()
									- img.getPixelReader().getColor(x, y - 1).getRed()
									- img.getPixelReader().getColor(x + 1, y).getRed()
									- img.getPixelReader().getColor(x, y + 1).getRed();
							r = Math.abs(r);
							r = r > 1.0 ? 1.0 : r;
							r = r < 0 ? 0 : r;

							double g = img.getPixelReader().getColor(x, y).getGreen() * 4
									- img.getPixelReader().getColor(x - 1, y).getGreen()
									- img.getPixelReader().getColor(x, y - 1).getGreen()
									- img.getPixelReader().getColor(x + 1, y).getGreen()
									- img.getPixelReader().getColor(x, y + 1).getGreen();
							g = Math.abs(g);
							g = g > 1.0 ? 1.0 : g;
							g = g < 0 ? 0 : g;

							double b = img.getPixelReader().getColor(x, y).getBlue() * 4
									- img.getPixelReader().getColor(x - 1, y).getBlue()
									- img.getPixelReader().getColor(x, y - 1).getBlue()
									- img.getPixelReader().getColor(x + 1, y).getBlue()
									- img.getPixelReader().getColor(x, y + 1).getBlue();
							b = Math.abs(b);
							b = b > 1.0 ? 1.0 : b;
							b = b < 0 ? 0 : b;

							//							return Color.rgb((int) r * 255, (int) g * 255, (int) b * 255);
							return Color.color(r, g, b);
						} else {
							return img.getPixelReader().getColor(x, y);
						}
					}).toImage();

		ImageIO.write(SwingFXUtils.fromFXImage(finalImage, null), "png", new File("src/test/java/ch03/out.png"));
	}

}
