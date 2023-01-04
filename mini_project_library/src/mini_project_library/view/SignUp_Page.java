package mini_project_library.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import mini_project_library.controller.user.CreateUserController;
import mini_project_library.controller.user.FindUserController;

public class SignUp_Page extends Stage {
	public SignUp_Page() {
		// Stage 만둘기
//		Stage signUpStage = new Stage();
		BorderPane signUpPage = new BorderPane();
		signUpPage.setPrefSize(300, 400);

		FlowPane signUpFlowPane = new FlowPane();
		signUpFlowPane.setPrefSize(300, 300);
		signUpFlowPane.setPadding(new Insets(20, 20, 20, 20));

		Label signUpTitle = new Label("회원 가입");
		signUpTitle.setPrefSize(300, 50);

		Label signUpIdLabel = new Label("아이디  ");
		signUpIdLabel.setPrefSize(300, 30);

		TextField signUpIdTextField = new TextField();
		signUpIdTextField.setPrefSize(200, 30);
		
		Button idCheckButton = new Button("중복확인");
		idCheckButton.setPrefSize(70, 30);
		idCheckButton.setOnAction(e -> {
			// 아이디 중복 확인
			FindUserController controller = new FindUserController(
					);
			controller.getResult(signUpIdTextField.getText());
		});

		Label signUpPWLabel1 = new Label("비밀번호  ");
		signUpPWLabel1.setPrefSize(70, 30);
		TextField signUpPWTextField1 = new TextField();
		signUpPWTextField1.setPrefSize(270, 30);

		Label signUpPWLabel2 = new Label("비밀번호 확인");
		signUpPWLabel2.setPrefSize(100, 30);
		TextField signUpPWTextField2 = new TextField();
		signUpPWTextField2.setPrefSize(270, 30);

		Label signUpNameLabel = new Label("이름");
		signUpNameLabel.setPrefSize(100, 30);
		TextField signUpNameTextField = new TextField();
		signUpNameTextField.setPrefSize(270, 30);

		Label signUpBlankLabel = new Label(" ");
		signUpBlankLabel.setPrefSize(300, 30);

		Button signUpConfirmButton = new Button("회원 가입");
		signUpConfirmButton.setPrefSize(270, 30);
		signUpConfirmButton.setOnAction(e1 -> {
			if (!signUpPWTextField1.getText().equals(signUpPWTextField2.getText())) {
				System.out.println("비밀번호가 다릅니다");
				Alert alert = new Alert(AlertType.ERROR);
				String alertContent = "비밀번호를 확인해 주세요";
				String alertTitle = "비밀번호가 일치하지 않습니다.";
				alert.setTitle("Error occured");
				alert.setHeaderText(alertTitle);
				alert.setContentText(alertContent);
				alert.showAndWait();
			} else {
				CreateUserController controller = new CreateUserController();
				int result = controller.createUser(signUpIdTextField.getText(), signUpPWTextField1.getText(),
						signUpNameTextField.getText());
				System.out.println(signUpPWTextField1.getText());
				System.out.println(result);
			}

		});

		signUpTitle.setAlignment(Pos.CENTER);

		signUpFlowPane.getChildren().add(signUpTitle);
		signUpFlowPane.getChildren().add(signUpIdLabel);
		signUpFlowPane.getChildren().add(signUpIdTextField);
		signUpFlowPane.getChildren().add(idCheckButton);
		signUpFlowPane.getChildren().add(signUpPWLabel1);
		signUpFlowPane.getChildren().add(signUpPWTextField1);
		signUpFlowPane.getChildren().add(signUpPWLabel2);
		signUpFlowPane.getChildren().add(signUpPWTextField2);
		signUpFlowPane.getChildren().add(signUpNameLabel);
		signUpFlowPane.getChildren().add(signUpNameTextField);
		signUpFlowPane.getChildren().add(signUpBlankLabel);
		signUpFlowPane.getChildren().add(signUpConfirmButton);

		signUpPage.setTop(signUpFlowPane);

		Scene signUpScene = new Scene(signUpPage);
//		this.initModality(Modality.WINDOW_MODAL);
//		signUpStage.initOwner(primaryStage);
		this.setScene(signUpScene);
		this.show();
	}
}
