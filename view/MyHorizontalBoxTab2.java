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
    }
}
