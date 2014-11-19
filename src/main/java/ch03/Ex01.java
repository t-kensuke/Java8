/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka
 */
package ch03;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex01 {

	static Logger logger = Logger.getGlobal();

	public static void main(String[] args) {
		Logger.getGlobal().setLevel(Level.ALL); // <---
		Logger.getGlobal().severe("severe");
		Logger.getGlobal().info("info");
		Logger.getGlobal().config("config");
		Logger.getGlobal().finest("finest");
	}

	public static void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
		if (logger.isLoggable(level)) {
			if (condition.get()) {
				logger.log(level, message.get());
			}
		}
	}

}
