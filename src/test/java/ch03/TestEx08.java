package ch03;
/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

public class TestEx08 extends TestCase {

	public void testTransform() throws IOException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));
		Color sampleColor = Color.RED;
		int width=5;
		Image out = Ex08.transform(img, Ex08.createTransformer(width, sampleColor));

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				if (x < width || img.getWidth() - width <= x || y < width || img.getHeight() - width <= y) {
					assertEquals(sampleColor, out.getPixelReader().getColor(x, y));
				}
			}
		}
		ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("src/test/java/ch03/out.png"));
	}

}
