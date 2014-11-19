/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import junit.framework.TestCase;

public class TestEx06 extends TestCase {

	public void testTransform() throws FileNotFoundException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));
		Image out = Ex06.transform(img, (c, factor) -> c.deriveColor(0, 1, factor, 1), 1.2);

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				assertTrue(img.getPixelReader().getColor(x, y).getBrightness() <= out.getPixelReader().getColor(x, y)
						.getBrightness());
			}
		}
	}

}
