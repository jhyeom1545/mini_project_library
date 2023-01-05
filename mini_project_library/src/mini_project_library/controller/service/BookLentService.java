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
		int bookLentResult=0; 
		int bookUpdateResult=0;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			BookLentDAO dao = new BookLentDAO(con);
			bookLentResult = dao.createLent(bookISBN, user_id);
			BookDAO bookDao = new BookDAO(con);
			bookUpdateResult = bookDao.statusUpdate(bookISBN);
			if(bookLentResult==1 && bookUpdateResult==1) {
				con.commit();
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookLentResult;
	}

	public ObservableList<LentVO> lentBookSearchByUserID(String user_id) {
		Connection con = null;
		ObservableList<LentVO> list = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			BookLentDAO dao = new BookLentDAO(con);
			list = dao.selectByUserID(user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
}
