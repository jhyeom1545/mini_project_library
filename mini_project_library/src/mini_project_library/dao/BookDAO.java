package mini_project_library.dao;

import java.sql.Connection;

public class BookDAO {
	Connection con;
	BookDAO(Connection con){
		this.con = con;
	}
}
