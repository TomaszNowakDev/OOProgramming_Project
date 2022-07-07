package component;

import javafx.scene.control.TextField;

public class MyTextField extends TextField {

	public MyTextField() {
		super();
		// style application for class from css file
		this.getStyleClass().add("text-field");
	}
}
