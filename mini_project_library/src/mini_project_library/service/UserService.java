package mini_project_library.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
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

	public UserVO findUserByID(String id) {
		Connection con = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDAO dao = new UserDAO(con);
		UserVO result = dao.findOne(id);
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
		System.out.println("userService :" + result);

		return result;
	}

	public void userInformationUpdate(UserVO updateUser) {
		Connection con = null;
		int count = 0;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			
			UserDAO dao = new UserDAO(con);
			count = dao.update(updateUser);
			if (count==1) {
				con.commit();
			} else {
				con.rollback();
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public int userDelete(String user_id) {
		Connection con = null;
		int count = 0;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			UserDAO dao = new UserDAO(con);
			count = dao.delete(user_id);
			if (count == 1) {
				con.commit();
			} else {
				con.rollback();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}

	public ObservableList<UserVO> findAllUser() {
		Connection con = null;
		ObservableList<UserVO> list = null;
		try {
			con = ConnectionPool.getDataSource().getConnection();
			con.setAutoCommit(false);
			UserDAO dao = new UserDAO(con);
			list = dao.findAll();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
