package mini_project_library.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Login_Page extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage managerStage = new Stage();
		BorderPane managerBorderPane = new BorderPane();
		managerBorderPane.setPrefSize(300, 400);
		// 플로우팬 생성 2개 Top, Bottom 
		FlowPane managerTopFlowPane = new FlowPane();
		managerTopFlowPane.setPrefSize(300, 100);
		managerTopFlowPane.setAlignment(Pos.CENTER);
		
		Label managerTitleLabel = new Label("관리자 메뉴");
		managerTitleLabel.setAlignment(Pos.CENTER);
		managerTitleLabel.setPrefSize(300, 40);
		
		Label managerSpaceLabel = new Label("");
		managerSpaceLabel.setPrefSize(40, 30);
		
		managerTopFlowPane.getChildren().add(managerTitleLabel);
		managerTopFlowPane.getChildren().add(managerSpaceLabel);
		
		
		FlowPane managerBottomFlowPane = new FlowPane();
		managerBorderPane.setTop(managerTopFlowPane);
		
		
		
		Scene managerScene = new Scene(managerBorderPane);
		managerStage.initOwner(primaryStage);
		managerStage.setScene(managerScene);
		managerStage.show();
		
		
	}
}
