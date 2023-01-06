package mini_project_library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mini_project_library.vo.BookVO;

public class BookDAO {
	Connection con;

	public BookDAO(Connection con) {
		this.con = con;
	}

	public ObservableList<BookVO> selectByKeyword(String keyword) {
		// 초기화
		ObservableList<BookVO> list = null;
		// 실행할 sql
		String sql = "SELECT * FROM book where book_title like ?";

		// 값을 담아줄 list선언
		list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVO book = new BookVO( //
						rs.getString("book_isbn"), //
						rs.getString("book_title"), //
						rs.getString("book_date"), //
						rs.getString("book_author"), //
						rs.getString("book_publisher"), //
						rs.getString("book_update"), //
						rs.getString("book_lent_status") //
				);
				list.add(book);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int statusUpdate(String bookISBN) {
		int count = 0;
		String sql = "UPDATE book SET book_lent_status='대출중' where book_isbn=? ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookISBN);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public void updateStatus(String book_isbn) {
		int count = 0;
		String sql = "update book set book_lent_status='대여가능' where book_isbn=? ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book_isbn);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insert(BookVO book) {
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO book (book_isbn, book_title, book_date, book_author, book_publisher, book_update, book_lent_status ) ");
		sql.append("VALUES (?, ?, NOW(), ?, ?, NULL, '대여가능' ) ");
		
		
//		private String book_isbn;
//		private String book_title;
//		private String book_date;
//		private String book_author;
//		private String book_publisher;
//		private String book_update;
//		private String book_lent_status;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, book.getBook_isbn());
			pstmt.setString(2, book.getBook_title());
			pstmt.setString(3, book.getBook_author());
			pstmt.setString(4, book.getBook_publisher());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
//	1. INSERT INTO 테이블이름(필드이름1, 필드이름2, 필드이름3, ...)
//	   VALUES (데이터값1, 데이터값2, 데이터값3, ...)
//	2. INSERT INTO 테이블이름
//	   VALUES (데이터값1, 데이터값2, 데이터값3, ...)
	
	
	
}
