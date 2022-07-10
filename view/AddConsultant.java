package view;

import java.util.ArrayList;
import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import controller.AppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

		hb = new HBox();
		this.hb.setSpacing(20);
		this.hb.setPadding(new Insets(20, 40, 20, 110));
		addButton = new MyButton("Save");
		addButton.setOnAction(e -> handleAdd());
		cancelButton = new MyButton("Cancel");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			cancelButton.getScene().getWindow().hide();
			}
		});
		this.getStyleClass().add("listView");
		hb.getChildren().addAll(addButton, cancelButton);

		this.t = new Text("Add new Consultant");
		t.setFont(Font.font("Lato", FontPosture.ITALIC, 20));
		this.setTop(t);
		this.setBottom(hb);
		this.setCenter(grid);
	}

	private void handleAdd() {
		int i = 0;
		String nameFirst = "", nameLast = "", id = "", phone = "", expertise = "";
		boolean valid = true;
		for (MyTextField t : this.texts) {
			if (!t.validate()) {
				valid = false;
			} else {

				if (i == 0) {
					nameFirst = t.getText();
				} else if (i == 1) {
					nameLast = t.getText();
				} else if (i == 2) {
					id = t.getText();
				} else if (i == 3) {
					phone = t.getText();
				} else {
					expertise = t.getText();
				}
			}
			i++;
		}
		if (valid) {
			this.consultant = new Consultant(new model.Name(nameFirst, nameLast), id, phone, null, expertise);
			AppController.getInstance().addConsultant(consultant);
			AppController.getInstance().refreshConsultants();
			this.clearView();
			System.out.println("Consultant added!");
		}
	}
}
