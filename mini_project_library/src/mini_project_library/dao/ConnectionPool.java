package mini_project_library.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {
	private static BasicDataSource basicDS;

	static {
		basicDS = new BasicDataSource(); // 일단 객체 맨들기!
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Driver 로딩 하기!
		basicDS.setUrl(
				"jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("manager");
		basicDS.setPassword("manager1234");
		basicDS.setInitialSize(10); // DB연결 일단 10개 만들어 볼게!
		basicDS.setMaxTotal(20); // 전체 Connection의 최대값
		System.out.println("연결 확인");
	}

	public static DataSource getDataSource() {
		return basicDS;
	}
}
