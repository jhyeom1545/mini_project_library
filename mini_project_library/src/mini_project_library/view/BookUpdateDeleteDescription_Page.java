package mini_project_library.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import mini_project_library.controller.book.BookUpdateController;
import mini_project_library.controller.book.DeleteBookController;
import mini_project_library.source.Alert_Window;
import mini_project_library.vo.BookVO;

public class BookUpdateDeleteDescription_Page extends Stage {
	BookUpdateDeleteDescription_Page(BookVO book) {
		// borderpane 만들기

		BorderPane userInformationBorderPane2 = new BorderPane();
		userInformationBorderPane2.setPrefSize(400, 800);
		userInformationBorderPane2.setPadding(new Insets(10, 50, 10, 50));

		FlowPane userInformationTopFlowPane2 = new FlowPane();
		userInformationBorderPane2.setPrefSize(400, 700);

		Label userInformationTitleLabel = new Label("도서 수정, 삭제");
		userInformationTitleLabel.setPrefSize(400, 30);
		userInformationTitleLabel.setAlignment(Pos.CENTER);

		Label userInformationSpaceLabel = new Label("");
		userInformationSpaceLabel.setPrefSize(400, 20);

		Label userInformationIDLabel = new Label("분류 번호");
		userInformationIDLabel.setPrefSize(100, 30);

		Label userInformationIDLabel2 = new Label(book.getBook_isbn());
		userInformationIDLabel2.setPrefSize(300, 30);

		Label userInformationSpaceLabel3 = new Label("");
		userInformationSpaceLabel3.setPrefSize(400, 10);

		Label userInformationNameLabel = new Label("도서 제목");
		userInformationNameLabel.setPrefSize(100, 30);

		TextField userInformationNameTextField = new TextField(book.getBook_title());
		userInformationNameTextField.setPrefSize(300, 30);

		Label userInformationSpaceLabel4 = new Label("");
		userInformationSpaceLabel4.setPrefSize(400, 10);

		Label userInformationPasswordLabel = new Label("도서 저자");
		userInformationPasswordLabel.setPrefSize(100, 30);

		TextField userInformationPasswordTextField = new TextField(book.getBook_author());
		userInformationPasswordTextField.setPrefSize(300, 30);

		Label userInformationSpaceLabel5 = new Label("");
		userInformationSpaceLabel5.setPrefSize(400, 10);

		Label userInformationSpaceLabel6 = new Label("");
		userInformationSpaceLabel6.setPrefSize(400, 10);

		Label userInformationPasswordLabel2 = new Label("출판사");
		userInformationPasswordLabel2.setPrefSize(100, 30);

		TextField userInformationPasswordTextField2 = new TextField(book.getBook_publisher());
		userInformationPasswordTextField2.setPrefSize(300, 30);

		Label userInformationSpaceLabel7 = new Label("");
		userInformationSpaceLabel7.setPrefSize(400, 10);

		Button userInformationUpdateButton = new Button("도서 정보 수정");
		userInformationUpdateButton.setPrefSize(400, 30);
		userInformationUpdateButton.setOnAction(e -> {
			// 도서 수정
			String book_isbn = userInformationIDLabel2.getText();
			String book_title = userInformationNameTextField.getText();
			String book_date = book.getBook_date();
			String book_author = userInformationPasswordTextField.getText();
			String book_publisher = userInformationPasswordTextField2.getText();
			String book_update = "NOW()";
			String book_lent_status = book.getBook_lent_status();

			BookVO bookVO = new BookVO( //
					book_isbn, book_title, book_date, //
					book_author, book_publisher, book_update, book_lent_status //
			);
			BookUpdateController controller = new BookUpdateController();
			int result = controller.getResult(bookVO);
			
			if(result==1) {
				new Alert_Window(AlertType.CONFIRMATION, "도서 수정", "도서 수정 완료", "도서 정보 수정이 완료되었습니다.");
//				this.close();
			} else {
				new Alert_Window(AlertType.ERROR, "도서 수정", "도서 수정 오류 발생", "도서 정보 수정에 실패하였습니다.");
			}
		});

		Label userInformationSpaceLabel8 = new Label("");
		userInformationSpaceLabel8.setPrefSize(400, 10);

		Separator separator = new Separator();
		separator.setPrefWidth(400);

		Label userInformationSpaceLabel9 = new Label("");
		userInformationSpaceLabel9.setPrefSize(400, 10);

		CheckBox deleteUserBox = new CheckBox();
		deleteUserBox.setPrefSize(30, 30);

		Button deleteUserButton = new Button("도서 삭제");
		deleteUserButton.setPrefSize(370, 30);
		deleteUserButton.setOnAction(e -> {
			// 도서 삭제
			if(deleteUserBox.isSelected()) {
				DeleteBookController controller = new DeleteBookController();
				String book_isbn = book.getBook_isbn();
				int result = controller.getResult(book_isbn);
				if (result==1) {
					new Alert_Window(AlertType.CONFIRMATION, "도서 삭제", "도서 삭제 성공", "도서 삭제 작업이 성공하였습니다.");
					this.close();
				} else {
					new Alert_Window(AlertType.ERROR,"도서 삭제", "도서 삭제 오류", "관리자에게 문의해 주세요");
				}
			} else {
				new Alert_Window(AlertType.ERROR,"도서 삭제", "도서 삭제 오류", "체크 박스를 확인해 주세요");
			}
		});

		userInformationTopFlowPane2.getChildren().add(userInformationTitleLabel);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel);
		userInformationTopFlowPane2.getChildren().add(userInformationIDLabel);
		userInformationTopFlowPane2.getChildren().add(userInformationIDLabel2);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel3);
		userInformationTopFlowPane2.getChildren().add(userInformationNameLabel);
		userInformationTopFlowPane2.getChildren().add(userInformationNameTextField);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel5);
		userInformationTopFlowPane2.getChildren().add(userInformationPasswordLabel);
		userInformationTopFlowPane2.getChildren().add(userInformationPasswordTextField);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel6);
		userInformationTopFlowPane2.getChildren().add(userInformationPasswordLabel2);
		userInformationTopFlowPane2.getChildren().add(userInformationPasswordTextField2);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel7);
		userInformationTopFlowPane2.getChildren().add(userInformationUpdateButton);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel8);
		userInformationTopFlowPane2.getChildren().add(separator);
		userInformationTopFlowPane2.getChildren().add(userInformationSpaceLabel9);
		userInformationTopFlowPane2.getChildren().add(deleteUserBox);
		userInformationTopFlowPane2.getChildren().add(deleteUserButton);

		FlowPane userInformationBottomFlowPane2 = new FlowPane();
		userInformationBorderPane2.setPrefSize(500, 500);

		userInformationBorderPane2.setTop(userInformationTopFlowPane2);
		userInformationBorderPane2.setBottom(userInformationBottomFlowPane2);

		Scene userInformationScene2 = new Scene(userInformationBorderPane2);
		this.setScene(userInformationScene2);
		this.show();
	}
	

}
