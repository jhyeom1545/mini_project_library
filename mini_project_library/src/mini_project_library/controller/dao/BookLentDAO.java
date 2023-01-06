package mini_project_library.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mini_project_library.vo.LentVO;

public class BookLentDAO {
	Connection con;

	public BookLentDAO(Connection con) {
		this.con=con;
	}

	public int createLent(String bookISBN, String user_id) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO book_lent (book_lent_date, book_isbn, user_id, book_return_date) ");
		sql.append("VALUES ( NOW(), ? , ? ,DATE_ADD(NOW(), INTERVAL 7 DAY)) ");
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bookISBN);
			pstmt.setString(2, user_id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	public ObservableList<LentVO> selectByUserID(String user_id) {
		PreparedStatement pstmt;
		ObservableList<LentVO> list = null;

		// SQL 쿼리 작성
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM book_lent l ");
		sql.append("inner join book b ");
		sql.append("ON L.book_isbn=B.book_isbn ");
		sql.append("where L.user_id=? and l.book_lent_status=1");
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next()) {
				LentVO lentVO = new LentVO(
						rs.getString("lent_id"), //
						rs.getString("book_isbn"), //
						rs.getString("book_title"), //
						rs.getString("book_date"), //
						rs.getString("book_author"), //
						rs.getString("book_publisher"), //
						rs.getString("book_lent_date"), //
						rs.getString("book_return_date") //
						);
				list.add(lentVO);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int update(LentVO lentBook) {
		StringBuffer sql = new StringBuffer();
		int count=0;
		sql.append("UPDATE book_lent ");
		sql.append("SET book_lent_status=0 , ");
		sql.append("book_actural_return_date=NOW() ");
		sql.append("where lent_id=? ");
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, lentBook.getLent_id());
			count = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(lentBook);
		System.out.println(count);
		return count;
	}

}
