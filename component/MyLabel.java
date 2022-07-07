package component;

import javafx.scene.control.Label;

public class MyLabel extends Label {
	
	public MyLabel(String text){
		super();
		this.setText(text);
		// style application for class from css file
		this.getStyleClass().add("label");
	}
}
