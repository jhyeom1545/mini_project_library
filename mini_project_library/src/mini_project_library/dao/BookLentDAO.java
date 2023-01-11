package mini_project_library.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini_project_library.vo.BookLentVO;
import mini_project_library.vo.InsertLentBookVO;
import mini_project_library.vo.LentVO;

public class BookLentDAO {

	private SqlSession session;
	public BookLentDAO(SqlSession session) {
		this.session = session;
	}
	
	// 대출 정보를 생성합니다.
	public int insert(InsertLentBookVO insertLentBook) {
		int result = session.insert("library.BookLent.insert", insertLentBook);
		return result;
	}
	
	// user_id에 대한 현재 대여중인 도서 리스트를 반환 
	public List<LentVO> selectByUserID(String user_id) {
		return session.selectList("library.BookLent.selectAllByUserID",user_id);
	}

	// 도서 정보 업데이트
	public int update(LentVO lentBook) {
		return session.update("library.BookLent.update",lentBook);
	}
	
	

	// 대출중인 모든 도서 대출 정보를 반환합니다.
	public List<BookLentVO> selectAll() {
		return session.selectList("library.BookLent.selectAll");
	}

}
