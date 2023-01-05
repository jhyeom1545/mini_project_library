package mini_project_library.controller.booklent;

import mini_project_library.controller.service.BookLentService;

public class BookLentByISBNController {

	public int getResult(String bookISBN, String user_id) {
		int result = 0;
		BookLentService service = new BookLentService();
		result = service.bookLentByISBN(bookISBN, user_id);
		return result;
	}

}
