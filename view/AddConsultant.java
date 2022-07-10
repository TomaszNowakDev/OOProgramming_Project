package view;

import java.util.ArrayList;
import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
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
		initUI();
	}

	private void initUI() {
		// adding to border pane
		this.setPadding(new Insets(20, 20, 20, 20));
		grid = new GridPane();
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
		this.texts.get(3).setPromptText("Phone");
		this.texts.get(4).setPromptText("Expertise");

		this.labels.add(new MyLabel("Consultant firstname:"));
		this.labels.add(new MyLabel("Consultant lastname:"));
		this.labels.add(new MyLabel("Consultant ID:"));
		this.labels.add(new MyLabel("Consultant phone:"));
		this.labels.add(new MyLabel("Consultant expertise:"));

		for (int i = 0; i < this.labels.size(); i++) {
			this.grid.add(this.labels.get(i), 0, i, 1, 1);
			this.grid.add(this.texts.get(i), 1, i, 1, 1);
		}

		this.setCenter(grid);
	}

}
