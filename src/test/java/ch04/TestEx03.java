/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.beans.property.StringProperty;
import junit.framework.TestCase;

public class TestEx03 extends TestCase {

	public void testEx03() throws Exception {

		Ex03 ex03 = new Ex03("default");

		assertNull(ex03.textProp);

		ex03.setText("text");
		assertEquals("text", ex03.getText());
		assertNotNull(ex03.textProp);

	}

}
