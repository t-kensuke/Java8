/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;
import ch03.Ex05.ColorTrasformer;

public class Ex11 {

	public static ColorTrasformer compose(ColorTrasformer ct1, ColorTrasformer ct2) {
		return (x, y, colorAtXY) -> {
			Color c1 = ct1.apply(x, y, colorAtXY);
			Color c2 = ct2.apply(x, y, c1);
			return c2;
		};
	}

	public static ColorTrasformer convert(UnaryOperator<Color> op) {
		return (x, y, colorAtXY) -> op.apply(colorAtXY);
	}



}
