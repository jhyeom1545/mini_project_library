package mini_project_library.controller.book;

import mini_project_library.service.BookService;
import mini_project_library.vo.BookVO;

public class CreateBookController {

	public int getResult(BookVO book) {
		BookService service = new BookService();
		int result = service.createBook(book);
		return result;
	}

}
