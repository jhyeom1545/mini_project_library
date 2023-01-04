package mini_project_library.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserInformation_Page extends Stage {
	public UserInformation_Page() {
		BorderPane userInformationBorderPane = new BorderPane();
		userInformationBorderPane.setPrefSize(400, 800);
		userInformationBorderPane.setPadding(new Insets(10, 50, 10, 50));

		FlowPane userInformationTopFlowPane = new FlowPane();
		userInformationBorderPane.setPrefSize(400, 700);

		Label userInformationTitleLabel = new Label("내 정보");
		userInformationTitleLabel.setPrefSize(400, 30);
		userInformationTitleLabel.setAlignment(Pos.CENTER);
		userInformationTitleLabel.setFont(Font.font("Cambria", 15));

		TextField imageField = new TextField();
		imageField.setPrefSize(400, 100);
		imageField.setAlignment(Pos.CENTER);

		Label userInformationSpaceLabel = new Label("");
		userInformationSpaceLabel.setPrefSize(400, 20);

		Label userInformationIDLabel = new Label("유저 아이디");
		userInformationIDLabel.setPrefSize(100, 30);

		Label userInformationIDLabel2 = new Label("홍길동");
		userInformationIDLabel.setPrefSize(100, 30);
		userInformationIDLabel.setAlignment(Pos.CENTER_LEFT);

		Label userInformationSpaceLabel2 = new Label("");
		userInformationSpaceLabel2.setPrefSize(200, 30);

		Label userInformationSpaceLabel3 = new Label("");
		userInformationSpaceLabel3.setPrefSize(400, 10);

		Label userInformationNameLabel = new Label("유저 이름");
		userInformationNameLabel.setPrefSize(100, 30);

		TextField userInformationNameTextField = new TextField();
		userInformationNameTextField.setPrefSize(300, 30);

		Label userInformationSpaceLabel4 = new Label("");
		userInformationSpaceLabel4.setPrefSize(400, 10);

		Label userInformationPasswordLabel = new Label("비밀번호");
		userInformationPasswordLabel.setPrefSize(100, 30);

		TextField userInformationPasswordTextField = new TextField();
		userInformationPasswordTextField.setPrefSize(300, 30);

		Label userInformationSpaceLabel5 = new Label("");
		userInformationSpaceLabel5.setPrefSize(400, 10);

		Label userInformationSpaceLabel6 = new Label("");
		userInformationSpaceLabel6.setPrefSize(400, 10);

		Label userInformationPasswordLabel2 = new Label("비밀번호 확인");
		userInformationPasswordLabel2.setPrefSize(100, 30);

		TextField userInformationPasswordTextField2 = new TextField();
		userInformationPasswordTextField2.setPrefSize(300, 30);

		Label userInformationSpaceLabel7 = new Label("");
		userInformationSpaceLabel7.setPrefSize(400, 10);

		Button userInformationUpdateButton = new Button("회원 정보 수정");
		userInformationUpdateButton.setPrefSize(400, 30);

		Label userInformationSpaceLabel8 = new Label("");
		userInformationSpaceLabel8.setPrefSize(400, 10);

		Separator separator = new Separator();
		separator.setPrefWidth(400);

		Label userInformationSpaceLabel9 = new Label("");
		userInformationSpaceLabel9.setPrefSize(400, 10);

		CheckBox deleteUserBox = new CheckBox();
		deleteUserBox.setPrefSize(30, 30);

		Button deleteUserButton = new Button("유저 삭제");
		deleteUserButton.setPrefSize(370, 30);

		userInformationTopFlowPane.getChildren().add(userInformationTitleLabel);
		userInformationTopFlowPane.getChildren().add(imageField);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel);
		userInformationTopFlowPane.getChildren().add(userInformationIDLabel);
		userInformationTopFlowPane.getChildren().add(userInformationIDLabel2);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel2);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel3);
		userInformationTopFlowPane.getChildren().add(userInformationNameLabel);
		userInformationTopFlowPane.getChildren().add(userInformationNameTextField);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel5);
		userInformationTopFlowPane.getChildren().add(userInformationPasswordLabel);
		userInformationTopFlowPane.getChildren().add(userInformationPasswordTextField);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel6);
		userInformationTopFlowPane.getChildren().add(userInformationPasswordLabel2);
		userInformationTopFlowPane.getChildren().add(userInformationPasswordTextField2);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel7);
		userInformationTopFlowPane.getChildren().add(userInformationUpdateButton);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel8);
		userInformationTopFlowPane.getChildren().add(separator);
		userInformationTopFlowPane.getChildren().add(userInformationSpaceLabel9);
		userInformationTopFlowPane.getChildren().add(deleteUserBox);
		userInformationTopFlowPane.getChildren().add(deleteUserButton);

		FlowPane userInformationBottomFlowPane = new FlowPane();
		userInformationBorderPane.setPrefSize(500, 500);

		userInformationBorderPane.setTop(userInformationTopFlowPane);
		userInformationBorderPane.setBottom(userInformationBottomFlowPane);

		Scene userInformationScene = new Scene(userInformationBorderPane);
		this.setScene(userInformationScene);
		this.show();
	}
}

