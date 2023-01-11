package mini_project_library.view;

import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.controller.book.BookSearchController;
import mini_project_library.vo.BookVO;

class BookUpdateDelte_Page extends Stage {
	BookVO book;
	String bookISBN;
	String bookLentStatus;
	Button lentButton;
	TextField imageField;
	BookUpdateDeleteDescription_Page newPage;

	public BookUpdateDelte_Page() {

		BorderPane userInformationBorderPane = new BorderPane();
		userInformationBorderPane.setPrefSize(400, 800);
		userInformationBorderPane.setPadding(new Insets(10, 50, 10, 50));

		FlowPane userInformationTopFlowPane = new FlowPane();
		userInformationBorderPane.setPrefSize(400, 700);

		Label userInformationTitleLabel = new Label("도서 정보 수정, 삭제");
		userInformationTitleLabel.setPrefSize(900, 30);
		userInformationTitleLabel.setAlignment(Pos.CENTER);
		userInformationTitleLabel.setFont(Font.font("Cambria", 15));

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
			// TableRow(테이블의 각 행)을 만들어서
			TableRow<BookVO> row = new TableRow<>();
			// 해당 행에 이벤트 처리를 설정한 다음
			row.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if (mouseEvent.getClickCount() == 2) {
						newPage = new BookUpdateDeleteDescription_Page(book);
					}
					if (mouseEvent.getClickCount() == 1) {
						book = row.getItem();
						bookISBN = book.getBook_isbn();
					}
				}
			});
			return row;
		});
		imageField = new TextField();
		imageField.setPrefSize(600, 30);
		imageField.setAlignment(Pos.CENTER);

		Button bookSearchButton = new Button("도서 검색");
		bookSearchButton.setPrefSize(300, 20);
		bookSearchButton.setOnAction(e -> {
			// 검색어를 입력하고 버튼을 누르면 검색
			BookSearchController controller = new BookSearchController();
			List<BookVO> result = controller.execute(imageField.getText());
			ObservableList<BookVO> list = FXCollections.observableArrayList();
			for (BookVO book1 : result) {
				list.add(book1);
			}
			bookTableView.setItems(list);
		});

		userInformationTopFlowPane.getChildren().add(userInformationTitleLabel);
		userInformationTopFlowPane.getChildren().add(bookTableView);
		userInformationTopFlowPane.getChildren().add(imageField);
		userInformationTopFlowPane.getChildren().add(bookSearchButton);

		FlowPane userInformationBottomFlowPane = new FlowPane();
		userInformationBorderPane.setPrefSize(500, 500);

		userInformationBorderPane.setTop(userInformationTopFlowPane);
		userInformationBorderPane.setBottom(userInformationBottomFlowPane);

		Scene userInformationScene = new Scene(userInformationBorderPane);
		this.setScene(userInformationScene);
		this.show();
	}
}