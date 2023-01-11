package mini_project_library.controller.booklent;

import mini_project_library.service.BookLentService;
import mini_project_library.vo.InsertLentBookVO;

public class BookLentByISBNController {

	public int execute(InsertLentBookVO insertLentBook) {
		BookLentService service = new BookLentService();
		System.out.println("실행 확인 Controller");
		return service.bookLentByISBN(insertLentBook);
	}

}
