package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
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
		initUI();
	}

	private void initUI() {

		this.setPadding(new Insets(50, 20, 20, 20));
		this.setSpacing(20);

		this.text = new Text("Recording Visit for Patient: " + patient.getName().getFullName());
		this.text.setFont(Font.font("Lato", FontPosture.ITALIC, 17));
		this.text2 = new Text("Date of Visit: " + LocalDate.now());
		this.text2.setFont(Font.font("Lato", FontPosture.ITALIC, 17));

		this.textArea = new TextArea();
		this.textArea.setPromptText("Add notes to the Visit");
		this.textArea.setWrapText(true);

		this.getChildren().addAll(text2, text, textArea, addHbox());
	}

	private HBox addHbox() {
		this.hb = new HBox();
		this.hb.setSpacing(10);
		this.submit.setOnAction(e -> handleAdd());
		cancelButton = new MyButton("Cancel");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cancelButton.getScene().getWindow().hide();
			}
		});
		this.hb.getChildren().addAll(submit, cancelButton);
		
		return this.hb;

	}
}
