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

public class TestEx15 extends TestCase {

	public void testTransform() throws IOException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/eiffel-tower.jpg"));
		Image finalImage = Ex15.LatentImage.from(img).transform(Color::grayscale).toImage();

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

				assertTrue(finalImage.getPixelReader().getColor(x, y).getBlue() == finalImage.getPixelReader()
						.getColor(x, y).getRed()
						&&
						finalImage.getPixelReader().getColor(x, y).getBlue() == finalImage.getPixelReader()
								.getColor(x, y).getGreen());
			}
		}
		ImageIO.write(SwingFXUtils.fromFXImage(finalImage, null), "png", new File("src/test/java/ch03/out.png"));
	}

}
