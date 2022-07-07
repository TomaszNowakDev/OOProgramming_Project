package controller;

import model.Consultant;
import model.ConsultantsList;
import java.io.Serializable;
import java.util.ArrayList;
import storage.Storage;
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
}