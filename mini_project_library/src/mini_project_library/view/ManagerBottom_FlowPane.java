package mini_project_library.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import mini_project_library.vo.UserVO;

class ManagerBottom_FlowPane extends FlowPane {
	public ManagerBottom_FlowPane(UserVO user) {
		this.setPrefSize(300, 300);
		this.setAlignment(Pos.CENTER);
		Label managerPageTitleLabel = new Label("관리자 페이지 입니다");
		Label managerBottomSpaceLabel0 = new Label();
		managerBottomSpaceLabel0.setPrefSize(300, 5);

		Button managerPageBookLogCheckButton = new Button("도서 대여 관리 기록 조회");
		managerPageBookLogCheckButton.setPrefSize(200, 30);
		managerPageBookLogCheckButton.setAlignment(Pos.CENTER);
		managerPageBookLogCheckButton.setOnAction(e -> {
			new BookLog_Page();
		});

		Label managerBottomSpaceLabel = new Label();
		managerBottomSpaceLabel.setPrefSize(300, 23);

		Button managerPageFindLentBookButtonButton = new Button("대여중인 모든 도서 목록");
		managerPageFindLentBookButtonButton.setPrefSize(200, 30);
		managerPageFindLentBookButtonButton.setAlignment(Pos.CENTER);
		managerPageFindLentBookButtonButton.setOnAction(e -> {
			new BookLentList_Page();
		});

		Label managerBottomSpaceLabel2 = new Label();
		managerBottomSpaceLabel2.setPrefSize(300, 23);

		Button managerPageBookEnrollButton = new Button("도서 등록");
		managerPageBookEnrollButton.setPrefSize(200, 30);
		managerPageBookEnrollButton.setAlignment(Pos.CENTER);
		managerPageBookEnrollButton.setOnAction(e -> {
			new EnrollBook_Page();
		});

		Label managerBottomSpaceLabel3 = new Label();
		managerBottomSpaceLabel3.setPrefSize(300, 23);

		Button managerPageBookUpdateButton = new Button("도서 정보 수정, 삭제");
		managerPageBookUpdateButton.setPrefSize(200, 30);
		managerPageBookUpdateButton.setAlignment(Pos.CENTER);
		managerPageBookUpdateButton.setOnAction(e -> {
			new BookUpdateDelte_Page();
		});

		Label managerBottomSpaceLabel4 = new Label();
		managerBottomSpaceLabel4.setPrefSize(300, 23);

		Button managerPageUserFindButton = new Button("전체 회원 조회");
		managerPageUserFindButton.setPrefSize(200, 30);
		managerPageUserFindButton.setAlignment(Pos.CENTER);
		managerPageUserFindButton.setOnAction(e -> {
			new UserView_Page(user);
		});

		this.getChildren().add(managerPageTitleLabel);
		this.getChildren().add(managerBottomSpaceLabel0);
		this.getChildren().add(managerPageBookLogCheckButton);
		this.getChildren().add(managerBottomSpaceLabel);
		this.getChildren().add(managerPageFindLentBookButtonButton);
		this.getChildren().add(managerBottomSpaceLabel2);
		this.getChildren().add(managerPageBookEnrollButton);
		this.getChildren().add(managerBottomSpaceLabel3);
		this.getChildren().add(managerPageBookUpdateButton);
		this.getChildren().add(managerBottomSpaceLabel4);
		this.getChildren().add(managerPageUserFindButton);
	}
}