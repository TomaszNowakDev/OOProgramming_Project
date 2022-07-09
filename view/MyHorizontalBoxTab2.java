package view;

import java.io.Serializable;

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
