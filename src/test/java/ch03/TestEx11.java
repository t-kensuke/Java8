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

public class TestEx11 extends TestCase {

	public void testTransform() throws IOException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));
		Image out = Ex05.transform(img, Ex11.compose(Ex11.convert(Color::brighter), (x, y, color) -> {
			if (x < 10 || img.getWidth() - 10 <= x || y < 10 || img.getHeight() - 10 <= y) {
				return Color.GRAY;
			} else {
				return img.getPixelReader().getColor(x, y);
			}
		}));
		ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("src/test/java/ch03/out.png"));
	}

}
