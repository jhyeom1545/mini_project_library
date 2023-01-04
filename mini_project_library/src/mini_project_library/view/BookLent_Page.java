package mini_project_library.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.controller.book.BookSearchController;
import mini_project_library.vo.BookVO;

class BookLent_Page extends Stage {
	public BookLent_Page() {
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

		Button searchButton = new Button("도서 검색");
		searchButton.setPrefSize(140, 30);
		searchButton.setOnAction(e-> {
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = 
					controller.getResult(bookSearchTextField.getText());
			bookTableView.setItems(list);
		});
		
		Button lentButton = new Button("대여 하기");
		lentButton.setPrefSize(140, 30);
		lentButton.setOnAction(e-> {
			// 누르면 대여합니다.
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