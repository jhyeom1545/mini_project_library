package mini_project_library.controller.booklent;

import javafx.collections.ObservableList;
import mini_project_library.controller.service.BookLentService;
import mini_project_library.vo.LentVO;

public class LentBookSearchController {

	public ObservableList<LentVO> getResult(String user_id) {
		BookLentService service = new BookLentService();
		ObservableList<LentVO> list = service.lentBookSearchByUserID(user_id);
		
		return list;
	}

}
