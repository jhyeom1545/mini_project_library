package mini_project_library.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mini_project_library.controller.booklent.LentBookReturnController;
import mini_project_library.controller.booklent.LentBookSearchController;
import mini_project_library.controller.point.AddPointToUserController;
import mini_project_library.vo.LentVO;
import mini_project_library.vo.UserVO;

class LentInformationReturn extends Stage {
	LentBookSearchController controller;
	LentBookSearchController controller2;
	List<LentVO> result;
	Label lentInformation;
	String user_id;
	TableView<LentVO> userLentBookTable;
	LentVO lentBook;

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
		String user_id = user.getUser_id();
		LentBookSearchController controller = new LentBookSearchController();
		result = controller.execute(user_id);

		ObservableList<LentVO> list = FXCollections.observableArrayList();

		for (LentVO lent1 : result) {
			list.add(lent1);
		}

		userLentBookTable.setItems(list);

		userLentBookTable.setRowFactory(e -> {
			TableRow<LentVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {

				// 내가 어떤 행을 클릭했는지 확인을 해야 하니..
				lentBook = row.getItem();
				System.out.println("lentBook "+ lentBook);

				// 삭제할 책의 ISBN을 버튼이 클리되었을때 알아내야 해요!
			});

			return row;
		});

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

		lentInformation = new Label("현재 " + list.size() + "권 대여중");
		lentInformation.setPrefSize(220, 30);

		Button returnButton = new Button("반납 하기");
		returnButton.setPrefSize(220, 30);
		returnButton.setOnAction(e -> {
			// 반납하는 코드
			LentBookReturnController lentBookReturnController = new LentBookReturnController();
			lentBookReturnController.getResult(lentBook);

			// 페이지 다시 로드
			ObservableList<LentVO> list2 = FXCollections.observableArrayList();
			LentBookSearchController controller2 = new LentBookSearchController();
			List<LentVO> result2 = controller2.execute(user_id);

			for (LentVO lent2 : result2) {
				list2.add(lent2);
			}

			userLentBookTable.setItems(list2);
			lentInformation.setText("현재 " + list2.size() + "권 대여중");

			// 반납하면 포인트를 지급할 꺼에요 10 point
			AddPointToUserController addPointToUserController = new AddPointToUserController();
			addPointToUserController.getResult(user.getUser_id());
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