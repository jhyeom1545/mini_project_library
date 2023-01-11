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
import mini_project_library.controller.user.FindAllUserController;
import mini_project_library.vo.UserVO;

class UserView_Page extends Stage {
	public UserView_Page(UserVO user) {

		BorderPane bookLentBorderPane = new BorderPane();
		bookLentBorderPane.setPrefSize(170, 300);
		bookLentBorderPane.setPadding(new Insets(10, 10, 10, 10));

		FlowPane bookLentTopFlowPane = new FlowPane();
		bookLentTopFlowPane.setPrefSize(170, 30);

		TableView<UserVO> pointTableView = new TableView<UserVO>();

		TableColumn<UserVO, String> isbnColumn = new TableColumn<>("회원 ID");
		isbnColumn.setMinWidth(50);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("user_id"));

		TableColumn<UserVO, String> titleColumn = new TableColumn<>("회원 이름");
		titleColumn.setMinWidth(50);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("user_name"));

		TableColumn<UserVO, String> authorColumn = new TableColumn<>("회원 포인트");
		authorColumn.setMinWidth(50);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("user_point"));

		pointTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn);

		// 전체 유저 조회하기
		FindAllUserController controller = new FindAllUserController();
//		List<HashMap<String,Object>> list = controller.getResult();
		List<UserVO> result = controller.getResult();
//		pointTableView.setItems(list);
		ObservableList<UserVO> list = FXCollections.observableArrayList();
		for(UserVO user1 : result) {
			list.add(user1);
		}
		pointTableView.setItems(list);
		// 컨트롤러는 뷰에 있는 이벤트를 처리하는 곳이에요 어떤 서비스, 어떤 이벤트와 연결해야 하는지
		// 이벤트 처리가 뷰로 와있음
		
		
//		UserVO updateUser = new UserVO(1231,123);
//		controller.execue(updateUser)

		
		
		// 포인트 내역 조회
		Label bookLentTitleLabel = new Label("전체 회원 조회");
		bookLentTitleLabel.setFont(Font.font("Cambria", 15));
		bookLentTitleLabel.setPrefSize(170, 30);
		bookLentTitleLabel.setAlignment(Pos.CENTER);

		bookLentTopFlowPane.getChildren().add(bookLentTitleLabel);
		bookLentTopFlowPane.getChildren().add(pointTableView);

		FlowPane bookLentBottomFlowPane = new FlowPane();
		bookLentBottomFlowPane.setPrefSize(170, 40);
		bookLentBottomFlowPane.setPadding(new Insets(10, 10, 10, 10));

		Label lentInformation = new Label(user.getUser_point()+" 포인트");
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
