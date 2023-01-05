package mini_project_library.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
