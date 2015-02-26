Files = java.nio.file.Files;
Paths = java.nio.file.Paths;

Application = javafx.application.Application;
FXCollections = javafx.collections.FXCollections;
ObservableList = javafx.collections.ObservableList;
Group = javafx.scene.Group;
Scene = javafx.scene.Scene;
PieChart = javafx.scene.chart.PieChart;
Stage = javafx.stage.Stage;
File = java.io.File;
StandardCharsets = java.nio.charset.StandardCharsets;
String = java.lang.String;
Arrays = java.util.Arrays;

if(arguments.length == 0){
	file = ".\\src\\test\\resources\\ch07\\ex10.txt"
} else {
	file = arguments[0];
}
print(file);
var contents = new String(Files.readAllBytes(Paths.get(new File(file).getPath())), StandardCharsets.UTF_8);
var lines = contents.split(/\r\n/);
var stream = Arrays.stream(Java.to(lines, "java.lang.String[]"))

var pieData = new Array()
stream.forEach(function(i) {
	var data = Java.to(i.split(/:/), "java.lang.String[]")
	if(data.length == 2){
		print(">>> " + data[0] + " =>" + data[1]);
		pieData.push(new PieChart.Data(data[0], data[1]));
	}
});

var pieChartData = FXCollections.observableArrayList(pieData);
var chart = new PieChart(pieChartData);

$STAGE.scene = new Scene(chart);
$STAGE.title = "Chart";
$STAGE.setWidth(500);
$STAGE.setHeight(500);
