package component;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class MyTextField extends TextField {

	public MyTextField() {
		super();
		// style application for class from css file
		this.getStyleClass().add("text-field");
	}

	// validating input fields
	public boolean validate() {
		// adding error if text is not valid
		if (this.getText().equals("")) {
			this.getStyleClass().add("error");
			this.addToolTip("Please fill out this field");
			return false;
		} else {
			// removing error style if field become valid
			this.getStyleClass().remove("error");
			this.setTooltip(null);
			return true;
		}
	}

	// adding ToolTip
	public void addToolTip(String message) {
		final Tooltip tooltip = new Tooltip();
		tooltip.setText(message);
		this.setTooltip(tooltip);
	}

}
