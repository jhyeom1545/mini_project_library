package mini_project_library.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mini_project_library.controller.book.CreateBookController;
import mini_project_library.source.Alert_Window;
import mini_project_library.vo.BookVO;

public class EnrollBook_Page extends Stage {
	public EnrollBook_Page() {
		// Stage 만둘기
//			Stage signUpStage = new Stage();
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
		TextField enrollBookTitleTextField = new TextField();
		enrollBookTitleTextField.setPrefSize(270, 30);

		Label enrollBookAuthorLabel = new Label("저자");
		enrollBookAuthorLabel.setPrefSize(100, 30);
		TextField enrollBookAuthorTextField = new TextField();
		enrollBookAuthorTextField.setPrefSize(270, 30);

		Label enrollBookPublisherLabel = new Label("출판사");
		enrollBookPublisherLabel.setPrefSize(100, 30);
		TextField enrollBookPublisherTextField = new TextField();
		enrollBookPublisherTextField.setPrefSize(270, 30);

		Label enrollBookBlankLabel = new Label("");
		enrollBookBlankLabel.setPrefSize(300, 30);

		Button enrollBookConfirmButton = new Button("등록 하기");
		enrollBookConfirmButton.setPrefSize(270, 30);
		enrollBookConfirmButton.setOnAction(e -> {
			String book_isbn = enrollBookISBNTextField.getText().toString();
			String book_title = enrollBookTitleTextField.getText().toString();
			String book_author = enrollBookAuthorTextField.getText().toString();
			String book_publisher = enrollBookPublisherTextField.getText().toString();
			
			BookVO book = new BookVO(book_isbn, book_title, book_author, book_publisher);
			CreateBookController controller = new CreateBookController();
			int result = controller.getResult(book);
			if(result==1) {
				new Alert_Window(AlertType.CONFIRMATION, "도서 등록", "도서 등록 확인", "도서 등록이 완료되었습니다.");
				enrollBookISBNTextField.clear();
				enrollBookTitleTextField.clear();
				enrollBookAuthorTextField.clear();
				enrollBookPublisherTextField.clear();
			} else {
				new Alert_Window(AlertType.ERROR, "도서 등록", "도서 등록 실패", "도서 등록이 실패하였습니다.");
			}
			
		});

		enrollBookTitleLabel.setAlignment(Pos.CENTER);

		signUpFlowPane.getChildren().add(enrollTitleLabel);
		signUpFlowPane.getChildren().add(enrollBookISBNLabel);
		signUpFlowPane.getChildren().add(enrollBookISBNTextField);
		signUpFlowPane.getChildren().add(enrollBookCheckISBNButton);
		signUpFlowPane.getChildren().add(enrollBookTitleLabel);
		signUpFlowPane.getChildren().add(enrollBookTitleTextField);
		signUpFlowPane.getChildren().add(enrollBookAuthorLabel);
		signUpFlowPane.getChildren().add(enrollBookAuthorTextField);
		signUpFlowPane.getChildren().add(enrollBookPublisherLabel);
		signUpFlowPane.getChildren().add(enrollBookPublisherTextField);
		signUpFlowPane.getChildren().add(enrollBookBlankLabel);
		signUpFlowPane.getChildren().add(enrollBookConfirmButton);

		enrollBookBorderPane.setTop(signUpFlowPane);

		Scene signUpScene = new Scene(enrollBookBorderPane);
		this.initModality(Modality.WINDOW_MODAL);
		this.setScene(signUpScene);
		this.show();
	}
}
