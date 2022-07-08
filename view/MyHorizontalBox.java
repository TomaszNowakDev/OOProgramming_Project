package view;

import java.io.Serializable;
import component.MyButton;
import controller.AppController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("serial")
public class MyHorizontalBox extends HBox implements Serializable {
    private VBox vb;
    private ListView<String> listView;
    private MyButton addPatient, editPatient, removePatient, recordVisit;
    private int selectedIndex = -1;
    protected ListProperty<String> listProperty = new SimpleListProperty<>();

    public MyHorizontalBox() {
        super();
        this.addPatient = new MyButton("Add Patient");
        this.editPatient = new MyButton("Edit Patient");
        this.removePatient = new MyButton("Remove Patient");
        this.recordVisit = new MyButton("Record Visit");
        initUI();
    }

    private void initUI() {
        // adding to the hbox
        this.getChildren().addAll(addListView(), addVBox());
    }

    private ListView<String> addListView() {
        this.listView = new ListView<String>();
        this.getStyleClass().add("listView");
        this.listView.setPadding(new Insets(20, 40, 20, 20));
        this.listView.prefHeight(300);
        this.listView.prefWidth(100);
        this.listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (AppController.getInstance().getConsultantData().size() > 0)
                    selectedIndex = listView.getSelectionModel().getSelectedIndex();
            }
        });
        this.setupListViewData();
        return listView;
    }

    private VBox addVBox() {
        this.vb = new VBox();
        this.vb.setSpacing(20);
        this.addPatient.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Parent root = new AddPatient();
                Stage stage = new Stage();
                stage.setTitle("Add new Patient");
                stage.setScene(new Scene(root, 400, 450));
                stage.show();
                setupListViewData();

            }
        });
    }
}