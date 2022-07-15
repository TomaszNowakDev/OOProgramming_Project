package view;

import java.util.ArrayList;
import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import controller.AppController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import model.Consultant;
import model.Patient;
import model.SeverityOptions;

public class AddPatient extends VBox {
	private ArrayList<MyTextField> texts;
	private ArrayList<MyLabel> labels;
	private GridPane grid;
	private HBox hb1;
	private HBox hb2;
	private ComboBox<String> comboBox;
	private ArrayList<String> ConsultantsData;
	protected Consultant selectedConsultant;
	private ButtonBase addButton;
	private MyButton cancelButton;
	private Text text;
	protected SeverityOptions SelectedSev;

	public AddPatient() {
		super();
		this.texts = new ArrayList<MyTextField>();
		this.labels = new ArrayList<MyLabel>();
		this.ConsultantsData = AppController.getInstance().getConsultantData();
		initUI();
	}

	private void initUI() {
		this.getChildren().addAll( addGridPane());

	}

	private GridPane addGridPane() {
		// adding gridPane and text fields with labels
		this.setPadding(new Insets(30, 20, 20, 40));
		this.grid = new GridPane();
		this.getStyleClass().add("mybutton");
		grid.setHgap(10);
		grid.setVgap(20);

		this.texts.add(new MyTextField());
		this.texts.add(new MyTextField());
		this.texts.add(new MyTextField());
		this.texts.add(new MyTextField());
		this.texts.add(new MyTextField());

		this.texts.get(0).setPromptText("Firstname");
		this.texts.get(1).setPromptText("Lastname");
		this.texts.get(2).setPromptText("ID");
		this.texts.get(3).setPromptText("phone");
		this.texts.get(4).setPromptText("Illness");

		this.labels.add(new MyLabel("Patient firstname:"));
		this.labels.add(new MyLabel("Patient lastname:"));
		this.labels.add(new MyLabel("Patient ID:"));
		this.labels.add(new MyLabel("Patient Phone:"));
		this.labels.add(new MyLabel("Patient Illness:"));

		for (int i = 0; i < this.labels.size(); i++) {
			this.grid.add(this.labels.get(i), 0, i, 1, 1);
			this.grid.add(this.texts.get(i), 1, i, 1, 1);
		}

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
}