package mini_project_library.source;

import javafx.scene.control.Alert;

public class Alert_Window extends Alert {
	public Alert_Window(AlertType alertType, String windowTitle, String title, String content) {
		super(alertType);
		this.setTitle(windowTitle);
		this.setHeaderText(title);
		this.setContentText(content);
		this.showAndWait();
	}
	
}
