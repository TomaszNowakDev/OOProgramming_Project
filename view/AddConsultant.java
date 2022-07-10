package view;

import java.util.ArrayList;
import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Consultant;

public class AddConsultant extends BorderPane {
	private ArrayList<MyTextField> texts;
	private ArrayList<MyLabel> labels;
	private GridPane grid;
	private HBox hb;
	private MyButton addButton, cancelButton;
	private Consultant consultant;
	private Text t;

	public AddConsultant() {
		super();
		this.texts = new ArrayList<MyTextField>();
		this.labels = new ArrayList<MyLabel>();

	}
}
