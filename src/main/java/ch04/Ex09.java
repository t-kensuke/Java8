/**
 * <p>Copyright: Copyright (c) 2014</p>
 *
 */
package ch04;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex09 extends Application {

	@Override
	public void start(final Stage stage) throws Exception {
		final Group root = new Group();
		stage.setScene(new Scene(root, 400, 200));

		Path path = ellipsePath(250, 100, 100, 30);
		root.getChildren().add(path);

		Rectangle rect = new Rectangle(0, 0, 30, 30);
		root.getChildren().add(rect);

		PathTransition transition = PathTransitionBuilder.create()
				.duration(Duration.seconds(10)).path(path).node(rect)
				.orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
				.cycleCount(Timeline.INDEFINITE).autoReverse(true).build();

		stage.show();
		transition.play();
	}

	private Path ellipsePath(double centerX, double centerY, double radiusX,
			double radiusY) {
		ArcTo arcTo = new ArcTo();
		arcTo.setX(centerX - radiusX + 1);
		arcTo.setY(centerY - radiusY);
		arcTo.setSweepFlag(false);
		arcTo.setLargeArcFlag(true);
		arcTo.setRadiusX(radiusX);
		arcTo.setRadiusY(radiusY);

		Path path = PathBuilder
				.create()
				.elements(new MoveTo(centerX - radiusX, centerY - radiusY),
						arcTo, new ClosePath()).build();
		return path;
	}

	public static void main(String[] args) {
		launch(args);
	}
}