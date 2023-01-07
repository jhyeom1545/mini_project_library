package mini_project_library.view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.controller.user.UserLoginController;
import mini_project_library.vo.BookVO;
import mini_project_library.vo.UserVO;

class BookLentListStage extends Stage {
	public BookLentListStage() {
		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(500, 500);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));

		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(100, 100);

		TableView<BookVO> bookTableView = new TableView<BookVO>();

		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(100);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		TableColumn<BookVO, Integer> pageColumn = new TableColumn<>("Page");
		pageColumn.setMinWidth(100);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));

		TableColumn<BookVO, Integer> publisherColumn = new TableColumn<>("Publisher");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("bpublisher"));

		TableColumn<BookVO, Integer> lentOkColumn = new TableColumn<>("대여 가능 여부");
		lentOkColumn.setMinWidth(150);
		lentOkColumn.setCellValueFactory(new PropertyValueFactory<>("book_return_date"));

		TableColumn<BookVO, Integer> returnDateColumn = new TableColumn<>("반납 예정일");
		returnDateColumn.setMinWidth(150);
		returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("book_return_date"));

		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, pageColumn, publisherColumn,
				lentOkColumn, returnDateColumn);

		Label bookLentTitleLabel = new Label("대여중인 모든 도서 목록");
		bookLentTitleLabel.setFont(Font.font("Cambria", 25));
		bookLentTitleLabel.setPrefSize(900, 40);
		bookLentTitleLabel.setAlignment(Pos.CENTER);

		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(bookTableView);

		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(920, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));
		bookLentBottomFlowPane.setHgap(430);

		Label managerLentInformation = new Label("현재 ~권 대여중");
		managerLentInformation.setPrefSize(220, 30);

		Label notReturnedBookLabel = new Label("현재 연채중인 도서는 ~권 입니다.");
		notReturnedBookLabel.setPrefSize(220, 30);

		bookLentBottomFlowPane.getChildren().add(managerLentInformation);
		bookLentBottomFlowPane.getChildren().add(notReturnedBookLabel);

		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);

		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();

	}
}



class ManagerBottomFlowPane extends FlowPane {
	public ManagerBottomFlowPane(UserVO user) {
		this.setPrefSize(300, 300);
		this.setAlignment(Pos.CENTER);
		Label managerPageTitleLabel = new Label("관리자 페이지 입니다");
		Label managerBottomSpaceLabel0 = new Label();
		managerBottomSpaceLabel0.setPrefSize(300, 5);

		Button managerPageBookLogCheckButton = new Button("도서 대여 관리 기록 조회");
		managerPageBookLogCheckButton.setPrefSize(200, 30);
		managerPageBookLogCheckButton.setAlignment(Pos.CENTER);
		managerPageBookLogCheckButton.setOnAction(e -> {
			Stage bookLogViewStage = new BookLog_Page();
		});

		Label managerBottomSpaceLabel = new Label();
		managerBottomSpaceLabel.setPrefSize(300, 23);

		Button managerPageFindLentBookButtonButton = new Button("대여중인 모든 도서 목록");
		managerPageFindLentBookButtonButton.setPrefSize(200, 30);
		managerPageFindLentBookButtonButton.setAlignment(Pos.CENTER);
		managerPageFindLentBookButtonButton.setOnAction(e -> {
			Stage bookLentListStage = new BookLentListStage();
		});

		Label managerBottomSpaceLabel2 = new Label();
		managerBottomSpaceLabel2.setPrefSize(300, 23);

		Button managerPageBookEnrollButton = new Button("도서 등록");
		managerPageBookEnrollButton.setPrefSize(200, 30);
		managerPageBookEnrollButton.setAlignment(Pos.CENTER);
		managerPageBookEnrollButton.setOnAction(e -> {
			Stage enrollBook_Page = new EnrollBook_Page();
		});

		Label managerBottomSpaceLabel3 = new Label();
		managerBottomSpaceLabel3.setPrefSize(300, 23);

		Button managerPageBookUpdateButton = new Button("도서 정보 수정, 삭제");
		managerPageBookUpdateButton.setPrefSize(200, 30);
		managerPageBookUpdateButton.setAlignment(Pos.CENTER);
		managerPageBookUpdateButton.setOnAction(e -> {
			Stage bookUpdateDelte_Page = new BookUpdateDelte_Page();
		});

		Label managerBottomSpaceLabel4 = new Label();
		managerBottomSpaceLabel4.setPrefSize(300, 23);

		Button managerPageUserFindButton = new Button("전체 회원 조회");
		managerPageUserFindButton.setPrefSize(200, 30);
		managerPageUserFindButton.setAlignment(Pos.CENTER);
		managerPageUserFindButton.setOnAction(e -> {
			Stage userViewStage = new UserView_Page(user);
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
			UserLoginController controller = new UserLoginController();
			//result => UserVO
			UserVO result = controller.getResult(textFieldID.getText(), textFieldPW.getText());
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
