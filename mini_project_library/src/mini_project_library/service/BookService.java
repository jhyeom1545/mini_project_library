package mini_project_library.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import mini_project_library.dao.BookDAO;
import mini_project_library.dao.ConnectionPool;
import mini_project_library.vo.BookVO;
import mini_project_library.vo.UserVO;

public class BookService {
	

	public ObservableList<BookVO> bookSearchByKeyword(String text) {
		Connection con = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		BookDAO dao = new BookDAO(con);
//		ObservableList<BookVO> list = dao.select(text);
		return null;

	}
}
