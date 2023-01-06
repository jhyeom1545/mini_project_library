package mini_project_library.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mini_project_library.vo.UserVO;

public class MainMenu_Page extends Stage {
	FlowPane loginBottomFlowPane;
	UserVO user;

	MainMenu_Page(UserVO user) {
//		Stage loginStage = new Stage();
// 보더 팬 생성
		BorderPane loginBorderPane = new BorderPane();
		loginBorderPane.setPrefSize(300, 400);

// 플로우팬 생성 2개 Top, Bottom
		FlowPane loginTopFlowPane = new FlowPane();
		loginTopFlowPane.setPrefSize(300, 100);
		Label loginTitleLabel = new Label("사용자 메뉴");
		loginTitleLabel.setAlignment(Pos.CENTER);
		loginTitleLabel.setPrefSize(300, 40);

		Button loginPageUserButton = new Button("사용자");
		loginPageUserButton.setPrefSize(60, 30);
		loginTopFlowPane.setAlignment(Pos.CENTER);
		loginPageUserButton.setOnAction(e3 -> {
			FlowPane loginBottomFlowPane = new LoginBottom_FlowPane(user);
			loginBorderPane.setBottom(loginBottomFlowPane);

		});

		Label loginSpaceLabel = new Label("");
		loginSpaceLabel.setPrefSize(40, 30);

		Button loginPageManagerButton = new Button("관리자");
		loginPageManagerButton.setPrefSize(60, 30);
		loginPageManagerButton.setOnAction(e2 -> {
			FlowPane managerBottomFlowPane = new ManagerBottomFlowPane(user);
			loginBorderPane.setBottom(managerBottomFlowPane);
		});
		loginTopFlowPane.getChildren().add(loginTitleLabel);
		loginTopFlowPane.getChildren().add(loginPageUserButton);
		loginTopFlowPane.getChildren().add(loginSpaceLabel);
		loginTopFlowPane.getChildren().add(loginPageManagerButton);

		loginBorderPane.setTop(loginTopFlowPane);
		loginBorderPane.setBottom(new LoginBottom_FlowPane(user));
		Scene loginScene = new Scene(loginBorderPane);
		this.initModality(Modality.WINDOW_MODAL);
		this.setScene(loginScene);
		this.show();
	}
}