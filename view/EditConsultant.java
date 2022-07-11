package view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Consultant;

public class EditConsultant extends VBox {
    private MyLabel label1, label2, label3, label4, label5;
    private MyTextField text1, text2, text3, text4, text5;
    private GridPane grid;
    private HBox hb;
    protected Consultant selectedConsultant;
    private MyButton saveButton, cancelButton;

    public EditConsultant(Consultant c) {
        this.selectedConsultant = c;
        this.text1 = new MyTextField();
        this.text2 = new MyTextField();
        this.text3 = new MyTextField();
        this.text4 = new MyTextField();
        initUI();
    }

    private void initUI() {
        this.getChildren().addAll(addGridPane());
    }

    private GridPane addGridPane() {
        // adding gridPane and text fields with labels

        label1 = new MyLabel("Consultant firstname:");
        label2 = new MyLabel("Consultant lastname:");
        label3 = new MyLabel("Consultant ID:");
        label4 = new MyLabel("Consultant phone:");
        label5 = new MyLabel("Consultant expertise:");

        this.grid = new GridPane();

        this.grid.add(text1, 1, 0);
        this.grid.add(text2, 1, 1);
        this.grid.add(text3, 1, 2);
        this.grid.add(text4, 1, 3);
        this.grid.add(text5, 1, 4);
        this.grid.add(label1, 0, 0);
        this.grid.add(label2, 0, 1);
        this.grid.add(label3, 0, 2);
        this.grid.add(label4, 0, 3);
        this.grid.add(label5, 0, 4);
        this.getStyleClass().add("vbox");
        grid.setHgap(10);
        grid.setVgap(20);

        return grid;
    }
}
