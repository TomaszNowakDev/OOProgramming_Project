package view;

import java.io.Serializable;
import component.MyButton;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyHorizontalBoxTab2 extends HBox implements Serializable {
    private VBox vb;
    private ListView<String> listView;
    private MyButton addConsultant, editConsultant, deleteConsultant;
    private int selectedIndex = -1;
    protected ListProperty<String> listProperty = new SimpleListProperty<>();

    public MyHorizontalBoxTab2() {
        super();
        this.deleteConsultant = new MyButton("Delete Consultant");
        this.editConsultant = new MyButton("Edit Consultant");
        initUI();
    }

    private void initUI() {
        this.getChildren().addAll(addListView(), addVBox());
    }

    private ListView<String> addListView() {
        this.listView = new ListView<String>();
        this.getStyleClass().add("listView");
        this.listView.setPadding(new Insets(20, 40, 20, 20));
        this.listView.prefHeight(300);
        this.listView.prefWidth(100);
        return listView;
    }

    private VBox addVBox() {
        this.vb = new VBox();
        this.getStyleClass().add("vbox");
        this.vb.setSpacing(20);
        this.addConsultant = new MyButton("Add Consultant");
        this.vb.setPadding(new Insets(60, 20, 20, 20));
        this.vb.getChildren().addAll(addConsultant, editConsultant, deleteConsultant);

        return vb;
}
