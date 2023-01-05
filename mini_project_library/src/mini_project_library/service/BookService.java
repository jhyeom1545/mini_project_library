package mini_project_library.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import mini_project_library.dao.BookDAO;
import mini_project_library.dao.ConnectionPool;
import mini_project_library.vo.BookVO;

public class BookService {
	

	public ObservableList<BookVO> bookSearchByKeyword(String keyword) {
		Connection con = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.selectByKeyword(keyword);
		
		
		return list;

	}
}
