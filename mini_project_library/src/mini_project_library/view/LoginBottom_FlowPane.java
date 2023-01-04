package mini_project_library.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LoginBottom_FlowPane extends FlowPane {
	// 클래스 안에 필드 생성자 메서드
	public LoginBottom_FlowPane() {
//			FlowPane this = new FlowPane();
		this.setPrefSize(300, 300);
		this.setAlignment(Pos.CENTER);

		Label loginPageTitleLabel = new Label("회원: 홍길동 | Point: 150점");
		Label loginBottomSpaceLabel0 = new Label();
		loginBottomSpaceLabel0.setPrefSize(300, 20);

		Button managerPageBookLogCheckButton = new Button("도서 대여");
		managerPageBookLogCheckButton.setPrefSize(200, 30);
		managerPageBookLogCheckButton.setAlignment(Pos.CENTER);
		managerPageBookLogCheckButton.setOnAction(e -> {
			Stage bookLentStage = new BookLent();
		});

		Label loginBottomSpaceLabel = new Label();
		loginBottomSpaceLabel.setPrefSize(300, 30);

		Button loginPageLentInformButton = new Button("대여 정보 조회 및 도서 반납");
		loginPageLentInformButton.setPrefSize(200, 30);
		loginPageLentInformButton.setAlignment(Pos.CENTER);
		loginPageLentInformButton.setOnAction(e -> {
			Stage lentInformationReturn = new LentInformationReturn();
		});

		Label loginBottomSpaceLabel2 = new Label();
		loginBottomSpaceLabel2.setPrefSize(300, 30);

		Button loginPagePointCheckButton = new Button("포인트 내역 조회");
		loginPagePointCheckButton.setPrefSize(200, 30);
		loginPagePointCheckButton.setAlignment(Pos.CENTER);
		loginPagePointCheckButton.setOnAction(e -> {
			Stage pointViewStage = new PointViewStage();
		});

		Label loginBottomSpaceLabel3 = new Label();
		loginBottomSpaceLabel3.setPrefSize(300, 30);

		Button loginPageUserInFormationButton = new Button("내 정보");
		loginPageUserInFormationButton.setPrefSize(200, 30);
		loginPageUserInFormationButton.setAlignment(Pos.CENTER);
		loginPageUserInFormationButton.setOnAction(e -> {
			Stage userInformation_Page = new UserInformation_Page();
		});

		this.getChildren().add(loginPageTitleLabel);
		this.getChildren().add(loginBottomSpaceLabel0);
		this.getChildren().add(managerPageBookLogCheckButton);
		this.getChildren().add(loginBottomSpaceLabel);
		this.getChildren().add(loginPageLentInformButton);
		this.getChildren().add(loginBottomSpaceLabel2);
		this.getChildren().add(loginPagePointCheckButton);
		this.getChildren().add(loginBottomSpaceLabel3);
		this.getChildren().add(loginPageUserInFormationButton);
	}
}