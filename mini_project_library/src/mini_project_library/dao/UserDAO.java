package mini_project_library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mini_project_library.vo.UserVO;

public class UserDAO {
	Connection con;

	public UserDAO(Connection con) {
		this.con = con;
	}

	public int create(String id, String pw, String name) {
		int count = 0;
//		con = null;
		String sql = "INSERT into user values (?, ?, ?, 0)";
		System.out.println("UserDAO " + id + " pw : " + pw + " name " + name);
		try {
			// DB연결
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 트랜젝션
//			con.setAutoCommit(false);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);

			count = pstmt.executeUpdate();
			System.out.println("executeUpdate 실행");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public boolean findOne(String id) {
		String sql = "SELECT * FROM user where user_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				UserVO user = new UserVO(rs.getString("user_id"), rs.getString("user_password"),
						rs.getString("user_name"), rs.getInt("user_point"));
				System.out.println(user);
				System.out.println("아이디 중복");
			} else {
				System.out.println("사용 가능");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public UserVO login(String user_id, String user_password) {
		UserVO result = null;
		String sql = "SELECT * from user where user_id=? and user_password=? ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserVO(rs.getString("user_id"), rs.getString("user_password"), rs.getString("user_name"),
						rs.getInt("user_point"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
