/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex08 extends Application {
	@FXML
	private TextField username;

	public void initialize(URL url, ResourceBundle rb) {
		System.out.println(username.getText());
	}

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ex08.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}
}
