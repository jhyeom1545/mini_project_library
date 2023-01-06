package mini_project_library.view;

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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import mini_project_library.vo.BookVO;
import mini_project_library.vo.UserVO;

class PointView_Page extends Stage {
	public PointView_Page(UserVO user) {

		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(170, 300);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));

		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(170, 30);

		TableView<BookVO> pointTableView = new TableView<BookVO>();

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

		Label bookLentTitleLabel = new Label();
		bookLentTitleLabel.setFont(Font.font("Cambria", 15));
		bookLentTitleLabel.setPrefSize(170, 30);
		bookLentTitleLabel.setAlignment(Pos.CENTER);
		bookLentTitleLabel.setText("포인트 내역 조회");
		bookLentTitleLabel.setTextAlignment(TextAlignment.CENTER);
		
		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(pointTableView);

		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(170, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));

		Label lentInformation = new Label( user.getUser_point() + " 포인트");
		lentInformation.setPrefSize(170, 30);
		lentInformation.setAlignment(Pos.CENTER);

		bookLentBottomFlowPane.getChildren().add(lentInformation);

		bookLentBorderPane.setTop(bookLentTopFlowPane);
		bookLentBorderPane.setBottom(bookLentBottomFlowPane);

		Scene bookLentScene = new Scene(bookLentBorderPane);
		this.setScene(bookLentScene);
		this.show();
	}
}
