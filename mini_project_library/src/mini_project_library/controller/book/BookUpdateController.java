package mini_project_library.controller.book;

import mini_project_library.service.BookService;
import mini_project_library.vo.BookVO;

public class BookUpdateController {

	public int getResult(BookVO bookVO) {
	BookService service = new BookService();
	int result = service.BookUpdate(bookVO);
		return result;
	}

}
