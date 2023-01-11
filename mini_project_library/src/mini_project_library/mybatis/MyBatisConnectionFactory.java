package mini_project_library.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory SqlSessionFactory;

	// static 블록 이용해서 클래스 로딩될 때 자동 실행되게 해요
	static {
		String resource = "./sqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);

			if (SqlSessionFactory == null) {
				SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private이니까 getter만들어 줬어요
	public static SqlSessionFactory getSqlSessionFactory() {
		return SqlSessionFactory;
	}

}
