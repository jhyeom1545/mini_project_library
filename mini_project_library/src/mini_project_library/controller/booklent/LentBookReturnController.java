package mini_project_library.controller.booklent;

import mini_project_library.service.BookLentService;
import mini_project_library.vo.LentVO;

public class LentBookReturnController {

	public void getResult(LentVO lentBook) {
		BookLentService service = new BookLentService();
		service.LentBookReturnByISBN(lentBook);
		
	}

}
