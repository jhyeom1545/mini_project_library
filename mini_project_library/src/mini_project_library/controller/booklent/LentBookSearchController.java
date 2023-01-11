package mini_project_library.controller.booklent;

import java.util.List;

import javafx.collections.ObservableList;
import mini_project_library.service.BookLentService;
import mini_project_library.vo.LentVO;

public class LentBookSearchController {

	public List<LentVO> execute(String user_id) {
		BookLentService service = new BookLentService();
		return service.lentBookSearchByUserID(user_id);
	}
}
