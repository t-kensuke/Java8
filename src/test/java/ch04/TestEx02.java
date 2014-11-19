/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * @author Tanaka Kensuke
 */
package ch04;

import javafx.beans.property.StringProperty;
import junit.framework.TestCase;

public class TestEx02 extends TestCase {

	public void testEx02() throws Exception {

		Ex02 ex02 = new Ex02();

		assertNull(ex02.textProp);

		ex02.setText("text");
		assertEquals("text", ex02.getText());
		assertNull(ex02.textProp);

		StringProperty textProp = ex02.textProperty();

		assertNotNull(ex02.textProp);

	}

}
