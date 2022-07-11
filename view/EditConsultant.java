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
        this.text5 = new MyTextField();
    }

}
