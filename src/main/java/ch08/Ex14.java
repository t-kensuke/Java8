package ch08;

import java.io.IOException;
import java.util.Objects;

public class Ex14 {
	public static void main(String[] args) throws IOException {

		Object obj = null;

		Objects.requireNonNull(obj, "obj must not be null."); //メッセージを追加
	}

}
