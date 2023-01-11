package mini_project_library.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import mini_project_library.controller.user.CreateUserController;
import mini_project_library.controller.user.FindUserController;
import mini_project_library.source.Alert_Window;
import mini_project_library.vo.UserVO;

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
			String user_id = signUpIdTextField.getText();
			if (signUpIdTextField.getText().equals("")) {
				new Alert_Window(AlertType.WARNING, "회원 가입", "아이디를 입력해 주세요", "아이디 필드가 비어 있습니다.");
			} else {
				FindUserController controller = new FindUserController();
				UserVO result = controller.execute(user_id);

				if (result == null) {
					// 결과가 존재하지 않으면 아이디 생성이 가능합니다.
					new Alert_Window(AlertType.CONFIRMATION, "회원 가입", "아이디 확인", "사용 가능한 아이디 입니다.");

				} else {
					// 결과가 존재하면 중복 아이디가 존재하기 때문에 경고창을 띄웁니다.
					new Alert_Window(AlertType.ERROR, "회원 가입", "아이디 오류", "이미 존재하는 아이디 입니다. \n다른 아이디를 입력해 주세요.");
				}
			}
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
		
		// 회원가입
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

				// 유저 객체 생성을 위한 value
				String user_id = signUpIdTextField.getText();
				String user_password = signUpPWTextField1.getText();
				String user_name = signUpNameTextField.getText();
				int user_point = 0;

				// 유저 객체 생성
				UserVO user = new UserVO(user_id, user_password, user_name, user_point);

				// controller 생성및 실행
				CreateUserController controller = new CreateUserController();
				int result = controller.execute(user);
				if (result ==1) {
					new Alert_Window(AlertType.CONFIRMATION, "회원 가입", "계정 생성", "아이디 생성이 완료되었습니다.");
					this.close();
				} else {
					new Alert_Window(AlertType.ERROR, "회원 가입", "계정 오류", "아이디 생성이 실패하였습니다. \n관리자에게 문의해 주세요.");
				}
				
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
