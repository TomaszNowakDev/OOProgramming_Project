package view;

import java.util.ArrayList;
import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import controller.AppController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	}
}