/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex07 extends Application {

	/* (非 Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) {
		final double rem = new Text("").getLayoutBounds().getHeight();

		GridPane pane = new GridPane();

		pane.setHgap(0.8 * rem);
		pane.setVgap(0.8 * rem);
		pane.setPadding(new Insets(0.8 * rem));

		Button okButton = new Button("Ok");
		Button cancelButton = new Button("Cancel");

		HBox buttons = new HBox(0.8 * rem);
		buttons.getChildren().addAll(okButton, cancelButton);
		buttons.setAlignment(Pos.CENTER);

		// CSSを使った方法
		//buttons.setStyle("-fx-border-color: red;");

		// CSS以外
		buttons.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));

		pane.add(buttons, 0, 2, 2, 1);

		stage.setScene(new Scene(pane));
		stage.show();
	}
}
