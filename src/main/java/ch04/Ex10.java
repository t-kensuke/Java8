/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Ex10 extends Application {
	/* (非 Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) {
		VBox root = new VBox();
		HBox menu = new HBox();
		Button backButton = new Button("Back");
		TextField url = new TextField("http://horstmann.com");
		menu.getChildren().addAll(backButton, url);

		String location = "http://horstmann.com";
		WebView browser = new WebView();
		WebEngine engine = browser.getEngine();
		engine.load(location);
		root.getChildren().addAll(menu, browser);

		backButton.setOnAction(event ->
		{
			if (engine.getHistory().getCurrentIndex() > 0) {
				engine.getHistory().go(-1);
			}
		});

		url.setOnAction((event) -> {
			engine.load(url.getText());
		});

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();
	}
}
