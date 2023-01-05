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
}
