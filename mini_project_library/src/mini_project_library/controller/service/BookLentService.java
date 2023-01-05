package mini_project_library.controller.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import mini_project_library.controller.dao.BookLentDAO;
import mini_project_library.dao.BookDAO;
import mini_project_library.dao.ConnectionPool;
import mini_project_library.vo.LentVO;

public class BookLentService {
	
	public int bookLentByISBN(String bookISBN, String user_id) {
		Connection con = null;
		int result = 0;
		
		try {
			con = ConnectionPool.getDataSource().getConnection();
			BookLentDAO dao = new BookLentDAO(con);
			result = dao.createLent(bookISBN, user_id);
			BookDAO bookDao = new BookDAO(con);
			bookDao.statusUpdate(bookISBN);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ObservableList<LentVO> lentBookSearchByUserID(String user_id) {
		return null;
	}
	
	
}
