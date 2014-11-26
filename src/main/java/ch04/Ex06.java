/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex06 extends Application {

	/* (非 Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
   public void start(Stage stage) {
      BorderPane pane = new BorderPane();
      Button top = new Button("Top");
      pane.setTop(top);
      pane.setAlignment(top, Pos.CENTER);
      pane.setLeft(new Button("Left"));
      pane.setCenter(new Button("Center"));
      pane.setRight(new Button("Right"));

      Button bottom = new Button("Bottom");
      pane.setBottom(bottom);
      pane.setAlignment(bottom, Pos.CENTER);

      stage.setScene(new Scene(pane));
      stage.show();
   }
}
