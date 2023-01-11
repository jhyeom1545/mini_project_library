package mini_project_library.controller.book;

import java.util.List;

import javafx.collections.ObservableList;
import mini_project_library.service.BookService;
import mini_project_library.vo.BookVO;

public class BookSearchController {

	public List<BookVO> execute(String keyword) {
		BookService service = new BookService();
		return service.bookSearchByKeyword(keyword);
	}
}
