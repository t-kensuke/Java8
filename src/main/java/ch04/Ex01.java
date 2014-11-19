/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex01 extends Application {

	/* (非 Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {

		Label message = new Label("Hello, JavaFX!");
		message.setFont(new Font(100));
		TextField text = new TextField("Hello, JavaFX!");

		message.textProperty().bind(text.textProperty());
		VBox pane = new VBox();
		pane.getChildren().addAll(message, text);

		stage.setScene(new Scene(pane));
		stage.setTitle("Hello");

		stage.show();

	}
}
