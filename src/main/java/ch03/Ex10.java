/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Ex10 {

	public static void main(String[] args) throws FileNotFoundException {

		Image img = new Image(new FileInputStream("src/test/java/ch03/sample.bmp"));
		Color sampleColor = new Color(1, 1, 1, 1);

		UnaryOperator<Color> op = Color::brighter;

		// Finction型からは変換できないため
		//Image out = Ex05.transform(img, op.compose(Color::grayscale));

	}

}
