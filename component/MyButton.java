package component;

import javafx.scene.control.Button;

public class MyButton extends Button{
	
	public MyButton(String text) {
		super();
		this.setText(text);
		// style application for class from css file
		this.getStyleClass().add("mybutton");
	}
}
