package mini_project_library.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini_project_library.dao.UserDAO;
import mini_project_library.mybatis.MyBatisConnectionFactory;
import mini_project_library.vo.LoginVO;
import mini_project_library.vo.UserVO;

public class UserService {
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	// 유저 회원 가입
	public int createUser(UserVO user) {
		int result = 0;
		SqlSession session = factory.openSession();
		UserDAO dao = new UserDAO(session);
		try {
			result = dao.insert(user);
			if (result==1) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return result;
	}
	
	public UserVO findUserByID(String user_id) {
		// 데이터베잇스 연결 하나당 하나가 정석
		SqlSession session = factory.openSession();
		UserDAO dao = new UserDAO(session);
		UserVO result = null;
		try {
			result = dao.selectOne(user_id);
		} catch (Exception e) {
			
		} finally {
			session.close();	
		}
		return result;
	}
	// factory
	public UserVO getLogin(LoginVO user) {
		UserVO result = null;
		SqlSession session = factory.openSession();
		UserDAO dao = new UserDAO(session);
		
		try {
			result = dao.select(user);
			// user_id
			// user_password
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return result;
	}

	public int userUpdate(UserVO updateUser) {
		int result = 0;
		SqlSession session = factory.openSession();
			UserDAO dao = new UserDAO(session);
			try {
				result = dao.update(updateUser);
				if (result==1) {
					session.commit();
				} else {
					session.rollback();
				}
			} catch (Exception e) {
				
			} finally {
				session.close();	
			}
			return result;
	}

	public int userDelete(String user_id) {
		SqlSession session = factory.openSession();
		int result = 0;
		UserDAO dao = new UserDAO(session);
		try {
			result = dao.delete(user_id);
			if (result==1) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
		}
		
		return result;

	}

	public List<UserVO> findAllUser() {
		List<UserVO> result = null;
		// session은 여기서 사용하고 닫아야 하니까 계속 선언 해줘야 해요
		SqlSession session = factory.openSession();
		UserDAO dao = new UserDAO(session);
		try {
			 result = dao.selectAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return result;
	}

	

}
