package mini_project_library.view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mini_project_library.controller.user.UserLoginController;
import mini_project_library.vo.LoginVO;
import mini_project_library.vo.UserVO;


public class Main_Page extends Application {
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 200); // 가로, 세로

		FlowPane flowpaneTop = new FlowPane();
		flowpaneTop.setColumnHalignment(HPos.CENTER);

		Label title = new Label("\n밝은 빛 도서관 도서관리 프로그램");
		flowpaneTop.setAlignment(Pos.CENTER);
		flowpaneTop.setPrefSize(500, 50);
		flowpaneTop.getChildren().add(title);

		FlowPane flowPaneCenter = new FlowPane();
		flowPaneCenter.setPadding(new Insets(10, 10, 10, 10));
		flowPaneCenter.setColumnHalignment(HPos.CENTER);
		flowPaneCenter.setPrefSize(480, 100);

		Label textID = new Label("아이디 ");
		Label textPW = new Label("패스워드 ");
		TextField textFieldID = new TextField();
		textFieldID.setPromptText("아이디");
		PasswordField textFieldPW = new PasswordField();
		textFieldPW.setPromptText("비밀번호");
		GridPane gridPaneCenter = new GridPane();

		gridPaneCenter.addRow(0, textID, textFieldID);
		gridPaneCenter.addRow(1, textPW, textFieldPW);
		gridPaneCenter.setAlignment(Pos.CENTER);

		FlowPane flowpaneBottom = new FlowPane();
		flowpaneBottom.setPadding(new Insets(10, 10, 10, 10));
		flowpaneBottom.setColumnHalignment(HPos.CENTER);
		flowpaneBottom.setPrefSize(100, 100);
		flowpaneBottom.setHgap(10);

		// login 버튼
		Button loginButton = new Button("로그인");
		loginButton.setPrefSize(90, 30);
		loginButton.setOnAction(e -> {
			
			// loginVO의 Value 준비
			String user_id = textFieldID.getText();
			String user_pw = textFieldPW.getText();
			
			// loginVO 생성
			LoginVO user = new LoginVO(user_id, user_pw);
			
			// 컨트롤러 실행
			UserLoginController controller = new UserLoginController();
			UserVO result = controller.execute(user);
			
			// 보통 컨트롤러에 인터페이스가 제공됩니다. (회사)
			// execute
			if (result == null) {
				Alert alert = new Alert(AlertType.ERROR);
				String alertContent = "아이디 혹은 비밀번호를 확인해 주세요";
				String alertTitle = "로그인 오류";
				alert.setTitle("Error occured");
				alert.setHeaderText(alertTitle);
				alert.setContentText(alertContent);
				alert.showAndWait();
			} else {
				// 스테이지 생성
				primaryStage.close();
				Stage mainMenu_Page = new MainMenu_Page(result);
			}
		});

		// 회원가입창 띄우기
		Button signUpButton = new Button("회원가입");
		signUpButton.setPrefSize(90, 30);
		signUpButton.setOnAction(e -> {
			Stage signUpPage = new SignUp_Page();
		});

		flowpaneBottom.getChildren().add(signUpButton);
		flowpaneBottom.getChildren().add(loginButton);
		flowpaneBottom.setAlignment(Pos.CENTER);

		root.setTop(flowpaneTop);
		root.setBottom(flowpaneBottom);
		root.setCenter(gridPaneCenter);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("밝은 빛 도서관");
		primaryStage.setOnCloseRequest(e5 -> {
			// 이벤트 처리
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
