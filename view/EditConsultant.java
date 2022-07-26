package view;

import component.MyButton;
import component.MyLabel;
import component.MyTextField;
import controller.AppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
		gridUpdate();
		this.setPadding(new Insets(20, 20, 20, 20));
		initUI();

	}

	private void initUI() {
		this.getChildren().addAll(addGridPane(), addHBox());
	}

	private HBox addHBox() {

		this.hb = new HBox();
		this.hb.setSpacing(10);
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
		this.hb.setPadding(new Insets(30, 20, 10, 65));
		return this.hb;
	}

	private GridPane addGridPane() {
		// adding gridPane and text fields with labels

		label1 = new MyLabel("Consultant firstname:");
		label2 = new MyLabel("Consultant lastname:");
		label3 = new MyLabel("Consultant ID:");
		label4 = new MyLabel("Consultant phone:");
		label5 = new MyLabel("Consultant expertise:");

		this.grid = new GridPane();

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
		this.getStyleClass().add("vbox");
		grid.setHgap(10);
		grid.setVgap(20);

		return grid;
	}

	private void gridUpdate() {
		// update consultant data in the grid
		text1.setText(AppController.getInstance().getConsultantList()
				.searchConsultants(selectedConsultant.getConsultantName()).getName().getFirstName());
		text2.setText(AppController.getInstance().getConsultantList()
				.searchConsultants(selectedConsultant.getConsultantName()).getName().getLastName());
		text3.setText(AppController.getInstance().getConsultantList()
				.searchConsultants(selectedConsultant.getConsultantName()).getID());
		text4.setText(AppController.getInstance().getConsultantList()
				.searchConsultants(selectedConsultant.getConsultantName()).getPhone());
		text5.setText(AppController.getInstance().getConsultantList()
				.searchConsultants(selectedConsultant.getConsultantName()).getExpertise());
	}

	private void handleEdit() {
		if (text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty()
				|| text4.getText().isEmpty() || text5.getText().isEmpty()) {
			System.out.println("Please fill in all empty fields!");
		} else {
			AppController.getInstance().getConsultantList().searchConsultants(selectedConsultant.getConsultantName())
					.getName().setFirstName(text1.getText());
			AppController.getInstance().getConsultantList().searchConsultants(selectedConsultant.getConsultantName())
					.getName().setLastName(text2.getText());
			AppController.getInstance().getConsultantList().searchConsultants(selectedConsultant.getConsultantName())
					.setPhone(text4.getText());
			AppController.getInstance().getConsultantList().searchConsultants(selectedConsultant.getConsultantName())
					.setId(text3.getText());
			AppController.getInstance().getConsultantList().searchConsultants(selectedConsultant.getConsultantName())
					.setExpertise(text5.getText());
			AppController.getInstance().refreshConsultants();
			System.out.println("Consultant's data updated!");
			saveButton.getScene().getWindow().hide();
		}
	}
}
