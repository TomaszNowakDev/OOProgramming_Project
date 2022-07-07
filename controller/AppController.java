package controller;

import model.Consultant;
import model.ConsultantsList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import storage.Storage;
import view.MyHorizontalBox;
import view.MyHorizontalBoxTab2;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
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

	// save function
	public void save() {
		this.store.save(obj);
	}

	// load function
	public void load() {
		Object o = this.store.read();
		if (o != null) {
			obj = (AppController) o;
		}
	}

	// set stage
	public void setStage(Stage s) {
		this.myStage = s;
	}

	// Initialization and css connection
	public void init(Stage st) {
		this.setStorage();
		this.load();
		this.myStage = st;
		st.setTitle("Hospital Consultancy Application");

		AppController.my_box1 = new MyHorizontalBox();
		tabPane = new TabPane();
		Tab tab1 = new Tab("Patient Management");
		tab1.setContent(my_box1);
		tab1.setClosable(false);
		tabPane.getTabs().add(tab1);

		AppController.my_box2 = new MyHorizontalBoxTab2();
		Tab tab2 = new Tab("Consultant Management");
		tab2.setContent(my_box2);
		tab2.setClosable(false);
		tabPane.getTabs().add(tab2);

		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem loadItem = new MenuItem("Load From File");
		loadItem.setOnAction(e -> load());
		MenuItem saveItem = new MenuItem("Save To File");
		saveItem.setOnAction(e -> save());
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Are you sure you want to quit the program?");
				alert.setContentText("Unsaved data will be lost!");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					Platform.exit();
				}
			}
		});
		fileMenu.getItems().addAll(loadItem, saveItem, new SeparatorMenuItem(), exitItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutItem = new MenuItem("About");
		aboutItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("About");
				alert.setHeaderText(null);
				alert.setContentText("Hospital Consultancy Application project.\n Project made by student Tomasz Nowak.");
				@SuppressWarnings("unused")
				Optional<ButtonType> result = alert.showAndWait();
			}
		});
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
