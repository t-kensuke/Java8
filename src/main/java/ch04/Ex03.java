/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ex03 {

	StringProperty textProp;
	String text;

	public Ex03(String text) {
		this.text = text;
	}

	public final StringProperty textProperty() {
		if (textProp == null) {
			textProp = new SimpleStringProperty(text);
		}
		return textProp;
	}

	public final void setText(String newValue) {
		if (textProp == null) {
			text = newValue;
			textProp = new SimpleStringProperty(text);
		} else {
			textProp.set(newValue);
		}
	}

	public final String getText() {
		if (textProp == null) {
			return text;
		} else {
			return textProp.get();
		}
	}

}
