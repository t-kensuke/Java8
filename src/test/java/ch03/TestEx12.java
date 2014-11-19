/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import junit.framework.TestCase;

public class TestEx12 extends TestCase {

	public void testTransform() throws FileNotFoundException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));

		Image finalImage = Ex12.LatentImage.from(img).transform(Color::brighter).transform(Color::grayscale).toImage();

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

//				assertTrue(img.getPixelReader().getColor(x, y).getBrightness() <= finalImage.getPixelReader()
//						.getColor(x, y)
//						.getBrightness());

				assertTrue(finalImage.getPixelReader().getColor(x, y).getBlue() == finalImage.getPixelReader()
						.getColor(x, y).getRed()
						&&
						finalImage.getPixelReader().getColor(x, y).getBlue() == finalImage.getPixelReader()
								.getColor(x, y).getGreen());
			}
		}
	}

}
