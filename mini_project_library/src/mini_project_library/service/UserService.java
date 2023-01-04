package mini_project_library.service;

import java.sql.Connection;
import java.sql.SQLException;

import mini_project_library.dao.ConnectionPool;
import mini_project_library.dao.UserDAO;
import mini_project_library.vo.UserVO;

public class UserService {
	public int createuser(String id, String pw, String name) {
		Connection con = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			System.out.println("커넥션 연결!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDAO dao = new UserDAO(con);
		System.out.println("UserService : " + "id: " + id + "pw: " + pw + "name: " + name);
		int result = dao.create(id, pw, name);
		if (result == 1) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean findUserByID(String id) {
		Connection con = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDAO dao = new UserDAO(con);
		boolean result = dao.findOne(id);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public UserVO getLogin(String user_id, String user_password) {
		Connection con = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDAO dao = new UserDAO(con);
		UserVO result = dao.login(user_id, user_password);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (result) {
//			con.commit();
//		} else {
//			con.rollback();
//		}
		System.out.println("userService :"+ result);
		
		return result;
	}

}
