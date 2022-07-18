package view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Patient;
import model.Visit;
import java.time.LocalDate;

import component.MyButton;

public class AddVisit extends VBox {
	private TextArea textArea;
	private Text text, text2;
	private MyButton submit, cancelButton;
	private Patient patient;
	private HBox hb;

	public AddVisit(Patient p) {
		super();
		this.patient = p;
		this.submit = new MyButton("Submit");
		}
}