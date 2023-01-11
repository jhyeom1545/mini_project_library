package mini_project_library.controller.booklent;

import java.util.List;

import mini_project_library.service.BookLentService;
import mini_project_library.vo.BookLentVO;

public class FindBookLentListController {

	public List<BookLentVO> getResult() {
		BookLentService service = new BookLentService();
		List<BookLentVO> list = service.findBookLentList();
		return list;
	}

}
