package view;

import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import controller.AppController;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Patient;
import model.SeverityOptions;

public class EditPatient extends VBox {
	private MyLabel label1, label2, label3, label4, label5;
	private MyTextField text1, text2, text3, text4, text5;
	private GridPane grid;
	private HBox hb;
	protected Patient selectedPatient;
	private MyButton saveButton, cancelButton;
	protected SeverityOptions SelectedSev;

	public EditPatient(Patient p) {
		this.selectedPatient = p;
		this.text1 = new MyTextField();
		this.text2 = new MyTextField();
		this.text3 = new MyTextField();
		this.text4 = new MyTextField();
		this.text5 = new MyTextField();
	}

}
