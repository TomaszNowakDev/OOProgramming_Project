package controller;

import model.Consultant;
import model.ConsultantsList;
import java.io.Serializable;
import java.util.ArrayList;
import storage.Storage;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import storage.SerialStorage;

public class AppController implements Serializable {
	private ConsultantsList prac;
	private static volatile AppController obj;
	private transient Stage myStage;
	private transient TabPane tabPane;
	private transient Scene myScene;
	private transient static MyHorizontalBoxTab2 my_box2;
	private transient static MyHorizontalBox my_box1;
	private Storage store;

	public AppController() {
		prac = new ConsultantsList();
	}

	// singleton to be sure that there will always be only one instance of the
	// controller
	public static AppController getInstance() {
		if (obj == null) {
			synchronized (AppController.class) {
				if (obj == null) {
					obj = new AppController();
					my_box1 = new MyHorizontalBox();
					my_box2 = new MyHorizontalBoxTab2();
				}
			}
		}
		return obj;
	}

	public ConsultantsList getConsulatants() {
		return prac;
	}

	public static AppController getObj() {
		return obj;
	}

	public Stage getMyStage() {
		return myStage;
	}

	public TabPane getTabPane() {
		return tabPane;
	}

	public Scene getMyScene() {
		return myScene;
	}

	public Storage getStore() {
		return store;
	}

	// set storage for serialfile
	private void setStorage() {
		store = new SerialStorage();
	}

	// Initialization and css connection
	public void init(Stage st) {
		this.setStorage();
		this.load();
		this.myStage = st;
		st.setTitle("Hospital Consultancy Application");

		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem loadItem = new MenuItem("Load From File");
		loadItem.setOnAction(e -> load());
		MenuItem saveItem = new MenuItem("Save To File");
		saveItem.setOnAction(e -> save());
		MenuItem exitItem = new MenuItem("Exit");

		fileMenu.getItems().addAll(loadItem, saveItem, new SeparatorMenuItem(), exitItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutItem = new MenuItem("About");

		helpMenu.getItems().add(aboutItem);
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		root.setTop(menuBar);

		root.setCenter(tabPane);
		myScene = new Scene(root, 510, 600);
		myScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.myStage.setScene(myScene);
		this.myStage.show();
	}
}
