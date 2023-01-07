package mini_project_library.controller.book;

import mini_project_library.service.BookService;

public class DeleteBookController {

	public int getResult(String book_isbn) {
		BookService service = new BookService();
		int result = service.deleteBook(book_isbn);
		return result;
	}
	
}
