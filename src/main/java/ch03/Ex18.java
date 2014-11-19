/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch03;

import java.util.function.Function;

public class Ex18 {

	public static <T, R> Function<T, R> unchecked(Ex18Function f) {
		//TODO
		return null;
	}

	@FunctionalInterface
	public interface Ex18Function {
		 Function call() throws Exception;
	}

}
