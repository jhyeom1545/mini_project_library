package mini_project_library.service;

import java.sql.Connection;
import java.sql.SQLException;

import mini_project_library.dao.ConnectionPool;

public class PointService {

	public void addPointToUser(String user_id) {
	Connection con = null;
			try {
				con = ConnectionPool.getDataSource().getConnection();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
