package clock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PropertyDialog implements Initializable {

	@FXML
	private ListView<String> fontFamilyList;

	@FXML
	private ListView<String> fontSizeList;

	@FXML
	private ListView<String> fontColorList;

	@FXML
	private ListView<String> backgroundColorList;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		final ObservableList<String> sizeListItems = FXCollections
				.observableArrayList("50", "100", "200", "300");
		fontSizeList.setItems(sizeListItems);

		final ObservableList<String> familyListItems = FXCollections
				.observableArrayList(Font.getFamilies());
		fontFamilyList.setItems(familyListItems);

		List<String> colors = new ArrayList<String>();
		for (Field f : Color.class.getFields()) {
			if (Modifier.isStatic(f.getModifiers())
					&& f.getType() == Color.class) {
				colors.add(f.getName());
			}
		}
		final ObservableList<String> colorListItems = FXCollections
				.observableArrayList(colors);
		fontColorList.setItems(colorListItems);

		backgroundColorList.setItems(colorListItems);

	}

	public void handleOKAction(ActionEvent event) {
		Stage stage = (Stage) okButton.getScene().getWindow();
		if (fontSizeList.getSelectionModel().getSelectedItems().size() == 1) {
			String fontSizeStr = fontSizeList.getSelectionModel()
					.getSelectedItems().toString(); // [50]
			DigitalClock.properties.put("fontSize",
					fontSizeStr.substring(1, fontSizeStr.length() - 1));
		}

		if (fontSizeList.getSelectionModel().getSelectedItems().size() == 1) {
			String fontFamilyStr = fontSizeList.getSelectionModel()
					.getSelectedItems().toString();
			DigitalClock.properties.put("fontFamily",
					fontFamilyStr.substring(1, fontFamilyStr.length() - 1));
		}

		if (fontColorList.getSelectionModel().getSelectedItems().size() == 1) {
			String fontColorStr = fontColorList.getSelectionModel()
					.getSelectedItems().toString();
			DigitalClock.properties.put("fontColor",
					fontColorStr.substring(1, fontColorStr.length() - 1));
		}

		if (backgroundColorList.getSelectionModel().getSelectedItems().size() == 1) {
			String backgroundColorStr = backgroundColorList.getSelectionModel()
					.getSelectedItems().toString();
			DigitalClock.properties.put("backgroundColor", backgroundColorStr
					.substring(1, backgroundColorStr.length() - 1));
		}

		stage.close();
	}

	public void handleCancelAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

}
