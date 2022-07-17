package view;

import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import controller.AppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
		gridUpdate();
		initUI();
	}

	private void initUI() {
		this.getChildren().addAll(addGridPane(), addHBox());
	}

	private GridPane addGridPane() {
		// adding gridPane and text fields with labels
		this.setPadding(new Insets(30, 20, 20, 60));

		this.label1 = new MyLabel("Patient firstname:");
		this.label2 = new MyLabel("Patient lastname:");
		this.label3 = new MyLabel("Patient ID:");
		this.label4 = new MyLabel("Patient Phone:");
		this.label5 = new MyLabel("Patient Illness:");

		this.grid = new GridPane();
		this.getStyleClass().add("mybutton");
		grid.setHgap(10);
		grid.setVgap(20);

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

		this.grid.add(new MyLabel("Illness severity:"), 0, 5);
		ComboBox<SeverityOptions> cbxSev = new ComboBox<>();
		cbxSev.getItems().setAll(SeverityOptions.values());
		cbxSev.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SelectedSev = cbxSev.getValue();
			}
		});
		this.grid.add(cbxSev, 1, 5);
		return grid;
	}

	private void gridUpdate() {
		// update Patient data in the grid

		text1.setText(AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getName().getFirstName());
		text2.setText(AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getName().getLastName());
		text3.setText(AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getID());
		text4.setText(AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getPhone());
		text5.setText(AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getIllness());
		SelectedSev = AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getSeverity();

	}

	private HBox addHBox() {

		this.hb = new HBox();
		this.hb.setSpacing(16);
		saveButton = new MyButton("Save Changes");
		saveButton.setOnAction(e -> handleEdit());
		cancelButton = new MyButton("Cancel");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cancelButton.getScene().getWindow().hide();
			}
		});

		hb.getChildren().addAll(saveButton, cancelButton);
		this.hb.setPadding(new Insets(30, 20, 10, 55));
		return this.hb;
	}

	private void handleEdit() {
		if (text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty()
				|| text4.getText().isEmpty() || text5.getText().isEmpty() || SelectedSev == null) {
			System.out.println("Please fill in all empty fields!");
		} else {
			AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getName().setFirstName(text1.getText());
			AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).getName().setLastName(text2.getText());
			AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).setId(text3.getText());
			AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).setPhone(text4.getText());
			AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).setIllness(text5.getText());
			AppController.getInstance().getConsultantList().searchPatient(selectedPatient.getPatientName()).setSeverity(SelectedSev);
			AppController.getInstance().refreshPatients();
			System.out.println("Patient's data updated!");
			saveButton.getScene().getWindow().hide();
		}
	}
}
