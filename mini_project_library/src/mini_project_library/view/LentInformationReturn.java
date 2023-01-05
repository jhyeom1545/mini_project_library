package mini_project_library.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.controller.booklent.LentBookSearchController;
import mini_project_library.vo.BookVO;
import mini_project_library.vo.LentVO;
import mini_project_library.vo.UserVO;

class LentInformationReturn extends Stage {
	public LentInformationReturn(UserVO user) {
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
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("book_title"));

		TableColumn<BookVO, String> authorColumn = new TableColumn<>("등록일");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("book_date"));

		TableColumn<BookVO, Integer> pageColumn = new TableColumn<>("저자");
		pageColumn.setMinWidth(100);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("book_author"));

		TableColumn<BookVO, Integer> publisherColumn = new TableColumn<>("출판사");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("book_publisher"));

		TableColumn<BookVO, Integer> lentOkColumn = new TableColumn<>("대출일");
		lentOkColumn.setMinWidth(150);
		lentOkColumn.setCellValueFactory(new PropertyValueFactory<>("book_lent_date"));

		TableColumn<BookVO, Integer> returnDateColumn = new TableColumn<>("반납 기한");
		returnDateColumn.setMinWidth(150);
		returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("book_return_date"));

		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, pageColumn, publisherColumn,
				lentOkColumn, returnDateColumn);

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
		lentInformation.setPrefSize(220, 30);

		Button returnButton = new Button("반납 하기");
		returnButton.setPrefSize(220, 30);
		returnButton.setOnAction(e-> {
			LentBookSearchController controller = new LentBookSearchController();
			ObservableList<LentVO> list = controller.getResult(user.getUser_id()); 
		});

		bookLentBottomFlowPane.getChildren().add(lentInformation);
		bookLentBottomFlowPane.getChildren().add(returnButton);

		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);

		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();

	}
}