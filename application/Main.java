package application;

import controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

// nice Low Coupling, High Cohesion Main class
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AppController.getInstance().init(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
