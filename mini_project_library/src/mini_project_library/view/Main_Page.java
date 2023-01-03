package mini_project_library.view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import mini_project_library.vo.BookVO;


class EnrollBookStage extends Stage {
	public EnrollBookStage() {
		// Stage 만둘기
//		Stage signUpStage = new Stage();
		BorderPane enrollBookBorderPane = new BorderPane();
		enrollBookBorderPane.setPrefSize(300, 400);

		FlowPane signUpFlowPane = new FlowPane();
		signUpFlowPane.setPrefSize(300, 300);
		signUpFlowPane.setPadding(new Insets(20, 20, 20, 20));

		Label enrollTitleLabel = new Label("도서 등록");
		enrollTitleLabel.setPrefSize(300, 50);
		enrollTitleLabel.setAlignment(Pos.CENTER);

		Label enrollBookISBNLabel = new Label("도서 번호");
		enrollBookISBNLabel.setPrefSize(300, 30);
		Button enrollBookCheckISBNButton = new Button("중복확인");
		enrollBookCheckISBNButton.setPrefSize(70, 30);

		TextField enrollBookISBNTextField = new TextField();
		enrollBookISBNTextField.setPrefSize(200, 30);

		Label enrollBookTitleLabel = new Label("도서 명");
		enrollBookTitleLabel.setPrefSize(50, 30);
		TextField signUpPWTextField1 = new TextField();
		signUpPWTextField1.setPrefSize(270, 30);

		Label signUpPWLabel2 = new Label("저자");
		signUpPWLabel2.setPrefSize(100, 30);
		TextField signUpPWTextField2 = new TextField();
		signUpPWTextField2.setPrefSize(270, 30);

		Label signUpNameLabel = new Label("페이지 수");
		signUpNameLabel.setPrefSize(100, 30);
		TextField signUpNameTextField = new TextField();
		signUpNameTextField.setPrefSize(270, 30);
		
		Label bookPublisherLabel = new Label("출판사");
		bookPublisherLabel.setPrefSize(100, 30);
		TextField bookPublisherTextField = new TextField();
		bookPublisherTextField.setPrefSize(270, 30);

		Label signUpBlankLabel = new Label("");
		signUpBlankLabel.setPrefSize(300, 30);

		Button signUpConfirmButton = new Button("등록 하기");
		signUpConfirmButton.setPrefSize(270, 30);

		enrollBookTitleLabel.setAlignment(Pos.CENTER);

		signUpFlowPane.getChildren().add(enrollTitleLabel);
		signUpFlowPane.getChildren().add(enrollBookISBNLabel);
		signUpFlowPane.getChildren().add(enrollBookISBNTextField);
		signUpFlowPane.getChildren().add(enrollBookCheckISBNButton);
		signUpFlowPane.getChildren().add(enrollBookTitleLabel);
		signUpFlowPane.getChildren().add(signUpPWTextField1);
		signUpFlowPane.getChildren().add(signUpPWLabel2);
		signUpFlowPane.getChildren().add(signUpPWTextField2);
		signUpFlowPane.getChildren().add(signUpNameLabel);
		signUpFlowPane.getChildren().add(signUpNameTextField);
		signUpFlowPane.getChildren().add(bookPublisherLabel);
		signUpFlowPane.getChildren().add(bookPublisherTextField);
		signUpFlowPane.getChildren().add(signUpBlankLabel);
		signUpFlowPane.getChildren().add(signUpConfirmButton);
		
		

		enrollBookBorderPane.setTop(signUpFlowPane);

		Scene signUpScene = new Scene(enrollBookBorderPane);
		this.initModality(Modality.WINDOW_MODAL);
		this.setScene(signUpScene);
		this.show();
	}
}


class UserInformationViewStage extends Stage {
	public UserInformationViewStage() {
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
		userInformationUpdateButton.setPrefSize(400,30);
		
		Label userInformationSpaceLabel8 = new Label("");
		userInformationSpaceLabel8.setPrefSize(400, 10);
		
		Separator separator = new Separator();
		separator.setPrefWidth(400);
		
		Label userInformationSpaceLabel9 = new Label("");
		userInformationSpaceLabel9.setPrefSize(400, 10);
		
		CheckBox deleteUserBox = new CheckBox();
		deleteUserBox.setPrefSize(30, 30);
		
		Button deleteUserButton = new Button("유저 삭제");
		deleteUserButton.setPrefSize(370,30);
		

		
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
		 
//		userInformationTopFlowPane.getChildren().add();
		
		
		
		FlowPane userInformationBottomFlowPane = new FlowPane();
		userInformationBorderPane.setPrefSize(500, 500);
		
		
		
		
		userInformationBorderPane.setTop(userInformationTopFlowPane);
		userInformationBorderPane.setBottom(userInformationBottomFlowPane);
		
		Scene userInformationScene = new Scene(userInformationBorderPane);
		this.setScene(userInformationScene);
		this.show();
	}
}


class LentInformationReturn extends Stage {
	public LentInformationReturn() {
		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(500, 500);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));
		
		
		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(100, 100);
		
		TableView<BookVO> bookTableView =  new TableView<BookVO>();
		
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
		
		
		
		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, pageColumn, publisherColumn, lentOkColumn, returnDateColumn);
		
		
		Label bookLentTitleLabel = new Label("대여 정보 조회 및 도서 반납");
		bookLentTitleLabel.setFont(Font.font("Cambria", 25));
		bookLentTitleLabel.setPrefSize(900, 40);
		bookLentTitleLabel.setAlignment(Pos.CENTER);
		
		
		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(bookTableView);
		
		
		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(920, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));
		bookLentBottomFlowPane.setHgap(430);

		Label lentInformation = new Label("현재 ~권 대여중");
		lentInformation.setPrefSize(220,30);
		
		Button 	returnButton = new Button("반납 하기");
		returnButton.setPrefSize(220, 30);
		
		
		bookLentBottomFlowPane.getChildren().add(lentInformation);
		bookLentBottomFlowPane.getChildren().add(returnButton);
		
		
		
		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);
		
		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();
	
	}
}

class PointViewStage extends Stage {
	public PointViewStage() {

		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(170, 300);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));
		
		
		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(170, 30);
		
		TableView<BookVO> pointTableView =  new TableView<BookVO>();
		
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("날짜");
		isbnColumn.setMinWidth(50);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<BookVO, String> titleColumn = new TableColumn<>("사유"); 
		titleColumn.setMinWidth(50);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("내용");
		authorColumn.setMinWidth(50);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		
		pointTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn);
		
		
		Label bookLentTitleLabel = new Label("포인트 내역 조회");
		bookLentTitleLabel.setFont(Font.font("Cambria", 15));
		bookLentTitleLabel.setPrefSize(170, 30);
		bookLentTitleLabel.setAlignment(Pos.CENTER);
		
		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(pointTableView);
		
		
		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(170, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));

		Label lentInformation = new Label("125 포인트");
		lentInformation.setPrefSize(170,30);
		lentInformation.setAlignment(Pos.CENTER);
		
		
		bookLentBottomFlowPane.getChildren().add(lentInformation);
		
		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);
		
		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();
	}
}


class BookLent extends Stage {
	public BookLent() {
		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(500, 500);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));
		
		
		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(100, 100);
		
		TableView<BookVO> bookTableView =  new TableView<BookVO>();
		
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
		
		
		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, pageColumn, publisherColumn, lentOkColumn, returnDateColumn);
		
		
		Label bookLentTitleLabel = new Label("도서 대여");
		bookLentTitleLabel.setFont(Font.font("Cambria", 25));
		bookLentTitleLabel.setPrefSize(900, 40);
		bookLentTitleLabel.setAlignment(Pos.CENTER);
		
		
		
		
		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(bookTableView);
		
		
		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(920, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));
		bookLentBottomFlowPane.setHgap(40);
		
		TextField bookSearchTextField = new TextField();
		bookSearchTextField.setPrefSize(600, 30);
		
		Button lentButton = new Button("대여 하기");
		lentButton.setPrefSize(220, 30);
		
		
		
		
		
		bookLentBottomFlowPane.getChildren().add(bookSearchTextField);
		bookLentBottomFlowPane.getChildren().add(lentButton);
		
		
		
		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);
		
		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();
	}
}

class LoginBottomFlowPane extends FlowPane {
	// 클래스 안에 필드 생성자 메서드
	
	public LoginBottomFlowPane() {
//		FlowPane this = new FlowPane();
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
		loginPageLentInformButton.setOnAction( e -> {
			Stage lentInformationReturn = new LentInformationReturn();
		});
			
		
		
		Label loginBottomSpaceLabel2 = new Label();
		loginBottomSpaceLabel2.setPrefSize(300, 30);

		Button loginPagePointCheckButton = new Button("포인트 내역 조회");
		loginPagePointCheckButton.setPrefSize(200, 30);
		loginPagePointCheckButton.setAlignment(Pos.CENTER);
		loginPagePointCheckButton.setOnAction(e-> {
			Stage pointViewStage = new PointViewStage();
		});

		Label loginBottomSpaceLabel3 = new Label();
		loginBottomSpaceLabel3.setPrefSize(300, 30);

		Button loginPageUserInFormationButton = new Button("내 정보");
		loginPageUserInFormationButton.setPrefSize(200, 30);
		loginPageUserInFormationButton.setAlignment(Pos.CENTER);
		loginPageUserInFormationButton.setOnAction(e -> {
			Stage userInformationViewStage = new UserInformationViewStage();
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

class ManagerBottomFlowPane extends FlowPane {
	public ManagerBottomFlowPane() {
		this.setPrefSize(300, 300);
		this.setAlignment(Pos.CENTER);
		Label managerPageTitleLabel = new Label("관리자 페이지 입니다");
		Label managerBottomSpaceLabel0 = new Label();
		managerBottomSpaceLabel0.setPrefSize(300, 5);

		Button managerPageBookLogCheckButton = new Button("도서 대여 관리 기록 조회");
		managerPageBookLogCheckButton.setPrefSize(200, 30);
		managerPageBookLogCheckButton.setAlignment(Pos.CENTER);
		managerPageBookLogCheckButton.setOnAction(e -> {
			Stage enrollBookStage = new EnrollBookStage();
		});

		Label managerBottomSpaceLabel = new Label();
		managerBottomSpaceLabel.setPrefSize(300, 23);

		Button managerPageFindLentBookButtonButton = new Button("대여중인 모든 도서 목록");
		managerPageFindLentBookButtonButton.setPrefSize(200, 30);
		managerPageFindLentBookButtonButton.setAlignment(Pos.CENTER);
		managerPageFindLentBookButtonButton.setOnAction(e -> {
			
		});

		Label managerBottomSpaceLabel2 = new Label();
		managerBottomSpaceLabel2.setPrefSize(300, 23);

		Button managerPageBookEnrollButton = new Button("도서 등록");
		managerPageBookEnrollButton.setPrefSize(200, 30);
		managerPageBookEnrollButton.setAlignment(Pos.CENTER);
		managerPageBookEnrollButton.setOnAction(e -> {
			
		});

		Label managerBottomSpaceLabel3 = new Label();
		managerBottomSpaceLabel3.setPrefSize(300, 23);

		Button managerPageBookUpdateButton = new Button("도서 정보 수정, 삭제");
		managerPageBookUpdateButton.setPrefSize(200, 30);
		managerPageBookUpdateButton.setAlignment(Pos.CENTER);
		managerPageBookUpdateButton.setOnAction(e -> {
			
		});

		Label managerBottomSpaceLabel4 = new Label();
		managerBottomSpaceLabel4.setPrefSize(300, 23);

		Button managerPageUserFindButton = new Button("전체 회원 조회");
		managerPageUserFindButton.setPrefSize(200, 30);
		managerPageUserFindButton.setAlignment(Pos.CENTER);
		managerPageUserFindButton.setOnAction(e -> {
			
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
	FlowPane loginBottomFlowPane = new LoginBottomFlowPane();
	FlowPane managerBottomFlowPane = new ManagerBottomFlowPane();
	
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
			// 스테이지 생성
			Stage loginStage = new Stage();
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
				loginBorderPane.setBottom(loginBottomFlowPane);
			});

			Label loginSpaceLabel = new Label("");
			loginSpaceLabel.setPrefSize(40, 30);

			Button loginPageManagerButton = new Button("관리자");
			loginPageManagerButton.setPrefSize(60, 30);
			loginPageManagerButton.setOnAction(e2 -> {
				loginBorderPane.setBottom(managerBottomFlowPane);
			});
			loginTopFlowPane.getChildren().add(loginTitleLabel);
			loginTopFlowPane.getChildren().add(loginPageUserButton);
			loginTopFlowPane.getChildren().add(loginSpaceLabel);
			loginTopFlowPane.getChildren().add(loginPageManagerButton);

			loginBorderPane.setTop(loginTopFlowPane);
			loginBorderPane.setBottom(loginBottomFlowPane);
			Scene loginScene = new Scene(loginBorderPane);
			loginStage.initModality(Modality.WINDOW_MODAL);
			loginStage.initOwner(primaryStage);
			loginStage.setScene(loginScene);
			loginStage.show();

		});
		Button signUpButton = new Button("회원가입");
		signUpButton.setPrefSize(90, 30);
		signUpButton.setOnAction(e3 -> {
			// Stage 만둘기
			Stage signUpStage = new Stage();
			BorderPane signUpPage = new BorderPane();
			signUpPage.setPrefSize(300, 400);

			FlowPane signUpFlowPane = new FlowPane();
			signUpFlowPane.setPrefSize(300, 300);
			signUpFlowPane.setPadding(new Insets(20, 20, 20, 20));

			Label signUpTitle = new Label("회원 가입");
			signUpTitle.setPrefSize(300, 50);

			Label signUpIdLabel = new Label("아이디  ");
			signUpIdLabel.setPrefSize(300, 30);
			Button idCheckButton = new Button("중복확인");
			idCheckButton.setPrefSize(70, 30);

			TextField signUpIdTextField = new TextField();
			signUpIdTextField.setPrefSize(200, 30);

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
			signUpStage.initModality(Modality.WINDOW_MODAL);
			signUpStage.initOwner(primaryStage);
			signUpStage.setScene(signUpScene);
			signUpStage.show();
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
