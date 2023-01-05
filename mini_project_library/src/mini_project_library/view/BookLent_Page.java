package mini_project_library.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.book.controller.BookLentOKCheckController;
import mini_project_library.controller.book.BookSearchController;
import mini_project_library.controller.booklent.BookLentByISBNController;
import mini_project_library.vo.BookVO;
import mini_project_library.vo.UserVO;

class BookLent_Page extends Stage {
	String bookISBN;
	String bookLentStatus;
	Button lentButton;

	public BookLent_Page(UserVO user) {
		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(500, 500);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));

		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(100, 100);

		TableView<BookVO> bookTableView = new TableView<BookVO>();

		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(100);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("book_isbn"));

		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(300);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("book_title"));

		TableColumn<BookVO, String> authorColumn = new TableColumn<>("등록일");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("book_date"));

		TableColumn<BookVO, Integer> pageColumn = new TableColumn<>("저자");
		pageColumn.setMinWidth(100);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("book_author"));

		TableColumn<BookVO, Integer> publisherColumn = new TableColumn<>("춢판사");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("book_publisher"));

		TableColumn<BookVO, Integer> returnDateColumn = new TableColumn<>("대여 가능 여부");
		returnDateColumn.setMinWidth(150);
		returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("book_lent_status"));

		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, pageColumn, publisherColumn,
				returnDateColumn);
		bookTableView.setRowFactory(e -> {
			TableRow<BookVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				
				// 내가 어떤 행을 클릭했는지 확인을 해야 하니..
				BookVO book = row.getItem();

				// 삭제할 책의 ISBN을 버튼이 클리되었을때 알아내야 해요!
				bookISBN = book.getBook_isbn();
				bookLentStatus = book.getBook_lent_status();

				// 대출중인 도서는 대출을 막습니다.
				if (bookLentStatus.equals("대출중")) {
					lentButton.setDisable(true);
				} else {
					lentButton.setDisable(false);
				}
			});

			return row;
		});

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
		bookSearchTextField.setPrefSize(500, 30);
		bookSearchTextField.setOnAction(e -> {
			// TextField에서 검색어를 입력하고 엔터치면 검색
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.getResult(bookSearchTextField.getText());
			bookTableView.setItems(list);
		});

		Button searchButton = new Button("도서 검색");
		searchButton.setPrefSize(140, 30);
		searchButton.setOnAction(e -> {
			// 검색어를 입력하고 버튼을 누르면 검색
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.getResult(bookSearchTextField.getText());
			bookTableView.setItems(list);
		});

		// 대여하기
		lentButton = new Button("대여 하기");
		lentButton.setPrefSize(140, 30);
		lentButton.setOnAction(e -> {
			// 책 빌리기!
			BookLentByISBNController controller = new BookLentByISBNController();
			int result = controller.getResult(bookISBN, user.getUser_id());
			if (result == 1) {
				// 리스트 새로고침
				BookSearchController bookSearchController = new BookSearchController();
				ObservableList<BookVO> list = bookSearchController.getResult(bookSearchTextField.getText());
				bookTableView.setItems(list);

				// 확인창 출력
				Alert alert = new Alert(AlertType.CONFIRMATION);
				String alertContent = "대여가 완료되었습니다.";
				String alertTitle = "도서 대여";
				alert.setTitle("밝은 빛 도서관");
				alert.setHeaderText(alertTitle);
				alert.setContentText(alertContent);
				alert.showAndWait();
			}
		});

		bookLentBottomFlowPane.getChildren().add(bookSearchTextField);
		bookLentBottomFlowPane.getChildren().add(searchButton);

		bookLentBottomFlowPane.getChildren().add(lentButton);

		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);

		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();
	}
}