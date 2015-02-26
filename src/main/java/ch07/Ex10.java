package ch07;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class Ex10 extends Application {

	public static String[] arguments = new String[]{".\\src\\test\\resources\\ch07\\PieChartData.txt"};

    @Override public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Group());
        stage.setTitle("Chart");
        stage.setWidth(500);
        stage.setHeight(500);

		String contents = new String(Files.readAllBytes(Paths
				.get(arguments[0])), StandardCharsets.UTF_8);

		String[] items = contents.split("\r\n");

		PieChart.Data[] data = new PieChart.Data[items.length];
		for(int i =0 ;i<items.length; i++){
			String[] item = items[i].split(":");

			data[i] = new PieChart.Data(item[0], Integer.valueOf(item[1]));
		}
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(data);
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}