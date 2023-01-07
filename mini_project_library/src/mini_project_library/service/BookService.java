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

	public int createBook(BookVO book) {
		Connection con = null;
		 try {
			con = ConnectionPool.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 BookDAO dao = new BookDAO(con);
		 int result = dao.insert(book);
				
		return result;
	}

	public int BookUpdate(BookVO bookVO) {
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);
			result = dao.update(bookVO);
			if(result==1) {
				con.commit();
			} else {
				con.rollback();
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteBook(String book_isbn) {
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);
			result = dao.delete(book_isbn);
			if(result==1) {
				con.commit();
			} else {
				con.rollback();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
