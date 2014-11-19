/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

public class TestEx05 extends TestCase {

	public void testTransform() throws FileNotFoundException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));
		Color sampleColor = new Color(1, 1, 1, 1);
		Image out = Ex05.transform(img, (x, y, color) -> sampleColor);

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				assertEquals(sampleColor, out.getPixelReader().getColor(x, y));
			}
		}
	}

	public void testTransformGray() throws IOException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));
		Color sampleColor = Color.GRAY;
		Image out = Ex05.transform(img, (x, y, color) -> {
			if (x < 10 || img.getWidth() - 10 <= x || y < 10 || img.getHeight() - 10 <= y) {
				return sampleColor;
			} else {
				return img.getPixelReader().getColor(x, y);
			}
		});

		ImageIO.write(SwingFXUtils.fromFXImage(out, null), "jpeg", new File("src/test/java/ch03/out.jpg"));
	}
}
