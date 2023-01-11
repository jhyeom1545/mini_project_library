package mini_project_library.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.controller.booklent.FindBookLentListController;
import mini_project_library.vo.BookLentVO;

class BookLentList_Page extends Stage {
	public BookLentList_Page() {
		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(500, 500);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));

		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(100, 100);

		TableView<BookLentVO> bookTableView = new TableView<BookLentVO>();

		TableColumn<BookLentVO, String> isbnColumn = new TableColumn<>("lent_id");
		isbnColumn.setMinWidth(100);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("lent_id"));

		TableColumn<BookLentVO, String> titleColumn = new TableColumn<>("book_lent_status");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("book_lent_status"));

		TableColumn<BookLentVO, String> bookReturnDateColumn = new TableColumn<>("book_lent_date");
		bookReturnDateColumn.setMinWidth(100);
		bookReturnDateColumn.setCellValueFactory(new PropertyValueFactory<>("book_lent_date"));
		
		TableColumn<BookLentVO, String> authorColumn = new TableColumn<>("book_return_date");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("book_return_date"));

		TableColumn<BookLentVO, String> actualReturnDate = new TableColumn<>("book_actural_return_date");
		actualReturnDate.setMinWidth(100);
		actualReturnDate.setCellValueFactory(new PropertyValueFactory<>("book_actural_return_date"));

		TableColumn<BookLentVO, String> publisherColumn = new TableColumn<>("book_isbn");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("book_isbn"));

		TableColumn<BookLentVO, String> lentOkColumn = new TableColumn<>("book_title");
		lentOkColumn.setMinWidth(150);
		lentOkColumn.setCellValueFactory(new PropertyValueFactory<>("book_title"));

		TableColumn<BookLentVO, String> returnDateColumn = new TableColumn<>("user_id");
		returnDateColumn.setMinWidth(150);
		returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("user_id"));

		bookTableView.getColumns().addAll(isbnColumn, titleColumn, bookReturnDateColumn, authorColumn, actualReturnDate, publisherColumn,
				lentOkColumn, returnDateColumn);
		
		FindBookLentListController controller = new FindBookLentListController();
//		ObservableList<BookLentVO>
		
		ObservableList<BookLentVO> list = FXCollections.observableArrayList();
		List<BookLentVO> result = controller.getResult();
		
		for(BookLentVO bookLent1: result) {
			list.add(bookLent1);
		}
		
		bookTableView.setItems(list);

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