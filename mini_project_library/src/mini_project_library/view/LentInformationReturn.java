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
import mini_project_library.vo.LentVO;
import mini_project_library.vo.LentVO;
import mini_project_library.vo.UserVO;

class LentInformationReturn extends Stage {
	LentBookSearchController controller;
	LentBookSearchController controller2;
	ObservableList<LentVO> list;
	ObservableList<LentVO> list2;
	TableView<LentVO> userLentBookTable;	
	public LentInformationReturn(UserVO user) {
		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(500, 500);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));

		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(100, 100);

		userLentBookTable = new TableView<LentVO>();

		TableColumn<LentVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(100);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("book_isbn"));

		TableColumn<LentVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("book_title"));

		TableColumn<LentVO, String> authorColumn = new TableColumn<>("등록일");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("book_date"));

		TableColumn<LentVO, String> pageColumn = new TableColumn<>("저자");
		pageColumn.setMinWidth(100);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("book_author"));

		TableColumn<LentVO, String> publisherColumn = new TableColumn<>("출판사");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("book_publisher"));

		TableColumn<LentVO, String> lentOkColumn = new TableColumn<>("대출일");
		lentOkColumn.setMinWidth(150);
		lentOkColumn.setCellValueFactory(new PropertyValueFactory<>("book_lent_date"));

		TableColumn<LentVO, String> returnDateColumn = new TableColumn<>("반납 기한");
		returnDateColumn.setMinWidth(150);
		returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("book_return_date"));

		userLentBookTable.getColumns().addAll(isbnColumn, titleColumn, authorColumn, pageColumn, publisherColumn,
				lentOkColumn, returnDateColumn);
		
		// 창 띄워주기
		LentBookSearchController controller = new LentBookSearchController();
		ObservableList<LentVO> list = controller.getResult(user.getUser_id());
		userLentBookTable.setItems(list);

		Label bookLentTitleLabel = new Label("대여 정보 조회 및 도서 반납");
		bookLentTitleLabel.setFont(Font.font("Cambria", 25));
		bookLentTitleLabel.setPrefSize(900, 40);
		bookLentTitleLabel.setAlignment(Pos.CENTER);

		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(userLentBookTable);

		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(920, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));
		bookLentBottomFlowPane.setHgap(430);

		Label lentInformation = new Label("현재 ~권 대여중");
		lentInformation.setPrefSize(220, 30);

		Button returnButton = new Button("반납 하기");
		returnButton.setPrefSize(220, 30);
		returnButton.setOnAction(e-> {
			controller2 = new LentBookSearchController();
			list2 = controller.getResult(user.getUser_id());
			userLentBookTable.setItems(list);
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