package mini_project_library.controller.book;

import javafx.collections.ObservableList;
import mini_project_library.service.BookService;
import mini_project_library.vo.BookVO;

public class BookSearchController {

	public ObservableList<BookVO> getResult(String keyword) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.bookSearchByKeyword(keyword);
		return list;
	}

}
