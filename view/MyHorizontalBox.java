package view;

import java.io.Serializable;
import component.MyButton;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
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
        this.getChildren().addAll(addVBox());
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