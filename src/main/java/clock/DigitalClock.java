/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package clock;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DigitalClock extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Canvas canvas;
	GraphicsContext gc;
	private Preferences prefs;
	static volatile Properties properties;

	/* (非 Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		prefs = Preferences.userNodeForPackage(this.getClass());
		properties = new Properties();
		loadProp(stage);
		stage.setOnCloseRequest(new javafx.event.EventHandler() {
			@Override
			public void handle(Event arg0) {
				storeProp(stage);
				javafx.application.Platform.exit();
			}
		});

		MenuBar menuBar = new MenuBar();

		Menu menuFile = new Menu("File");
		MenuItem property = new MenuItem("Property");

		property.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					show(event);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		menuFile.getItems().addAll(property);
		menuBar.getMenus().addAll(menuFile);

		canvas = new Canvas();
		gc = canvas.getGraphicsContext2D();

		// create an animation (update & render loop)
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				gc.setFont(new Font(properties.getProperty("fontFamily", "Arial"), Double.parseDouble(properties.getProperty("fontSize", "100"))));
				gc.setFill(Color.valueOf(properties.getProperty("fontColor", "GRAY")));

				gc.setFill(Color.valueOf(properties.getProperty("backgroundColor", "GRAY")));
				gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

				Date date = new Date();
				String drawStr = sdf.format(date);

				float width = com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().computeStringWidth(drawStr, gc.getFont());
				float height = com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().getFontMetrics(gc.getFont()).getLineHeight();
				canvas.setWidth(width);
				canvas.setHeight(height);
				gc.setFill(Color.valueOf(properties.getProperty("fontColor", "GRAY")));
				gc.fillText(drawStr, 0, height - 10);
				stage.setWidth(width + 20);
				stage.setHeight(height + 70);

			}
		}.start();

		VBox pane = new VBox();
		pane.getChildren().addAll(menuBar, canvas);
		stage.setScene(new Scene(pane));
		stage.setTitle("DigitalClock");

		stage.show();

	}

	public void show(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Parent root = (Parent) loader.load(getClass().getResource("propertyDialog.fxml"));

		stage.setScene(new Scene(root));
		stage.setTitle("Property");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((MenuItem) event.getSource()).getParentPopup().getOwnerWindow());

		stage.show();

	}

	private void loadProp(Stage stage) {
		try {
			double x = Double.parseDouble(prefs.get("x", "300"));
			double y = Double.parseDouble(prefs.get("y", "200"));
			stage.setX(x);
			stage.setY(y);
		} catch (Exception e) {
			stage.setX(300);
			stage.setY(200);
		}

		properties.put("fontSize", prefs.get("fontSize", "100"));
		properties.put("fontColor", prefs.get("fontColor", "BLACK"));
		properties.put("backgroundColor", prefs.get("backgroundColor", "GRAY"));
		properties.put("fontFamily", prefs.get("fontFamily", "Arial"));
	}

	private void storeProp(Stage stage) {

		prefs.put("x", "" + stage.getX());
		prefs.put("y", "" + stage.getY());
		prefs.put("fontSize", properties.getProperty("fontSize", "100"));
		prefs.put("fontColor", properties.getProperty("fontColor", "BLACK"));
		prefs.put("backgroundColor", properties.getProperty("backgroundColor", "GRAY"));
		prefs.put("fontFamily", properties.getProperty("fontFamily", "Arial"));
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}

	}

}
