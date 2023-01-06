package mini_project_library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
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

	public UserVO findOne(String id) {
		String sql = "SELECT * FROM user where user_id=?";
		UserVO result = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserVO(rs.getString("user_id"), rs.getString("user_password"), rs.getString("user_name"),
						rs.getInt("user_point"));
				System.out.println("아이디 중복");
			} else {
				System.out.println("사용 가능");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public UserVO login(String user_id, String user_password) {
		UserVO result = null;
		String sql = "SELECT * from user where user_id=? and user_password=? and is_deleted is Null ";
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

	public int update(UserVO updateUser) {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE user SET user_name=?, user_password=?, user_point=? where user_id=? ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, updateUser.getUser_name());
			pstmt.setString(2, updateUser.getUser_password());
			pstmt.setInt(3, updateUser.getUser_point());
			pstmt.setString(4, updateUser.getUser_id());
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int delete(String user_id) {
		int count = 0;
		String sql = "UPDATE user SET is_deleted=NOW() where user_id=? ";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			count = pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public ObservableList<UserVO> findAll() {
		ObservableList<UserVO> list = null;
		String sql = "Select * FROM user ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while (rs.next()) {
				UserVO user = new UserVO(rs.getString("user_id"),
						rs.getString("user_password"), rs.getString("user_name"), rs.getInt("user_point"));
				list.add(user);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
