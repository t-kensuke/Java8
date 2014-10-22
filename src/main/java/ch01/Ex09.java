/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch01;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex09 {

	public interface Collection2<T> extends Collection<T> {
		default void forEachIf(Consumer<T> action, Predicate<T> filter) {
			forEach(e -> {
				if (filter.test(e)) {
					action.accept(e);
				}
			});
		}

	}
}
