package mini_project_library.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini_project_library.vo.LoginVO;
import mini_project_library.vo.UserVO;

public class UserDAO {
	private SqlSession session;

	public UserDAO(SqlSession session) {
		this.session = session;
	}

	
	// 유저 생성
	public int insert(UserVO user) {
		return session.insert("library.User.insert", user);
	}

	// 유저 id로 찾기(아이디 중복 확인)
	public UserVO selectOne(String user_id) {
		return session.selectOne("library.User.selectOne", user_id);
	}

	// 유저 로그인
	public UserVO select(LoginVO user) {
		return session.selectOne("library.User.login", user);
	}

	// 모든 회원 조회
	public List<UserVO> selectAll() {
		return session.selectList("library.User.selectAll");
	}

	// 유저 정보 수정
	public int update(UserVO updateUser) {
		return session.update("library.User.update", updateUser);
	}

	// 유저 삭제
	public int delete(String user_id) {
		return session.delete("library.User.delete", user_id);
	}
}
