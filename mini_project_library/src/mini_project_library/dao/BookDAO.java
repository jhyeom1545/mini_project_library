package mini_project_library.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini_project_library.vo.BookVO;

public class BookDAO {
	private SqlSession session;
	public BookDAO(SqlSession session) {
		this.session = session;
	}

	// 도서 키워드로 검색
	public List<BookVO> selectByKeyword(String keyword) {
		return session.selectList("library.Book.selectByKeyword", keyword);
	}

	// 도서 정보 업데이트
	public int update(BookVO bookVO) {
		return session.update("library.Book.update", bookVO);
	}
	
	// 상태 '대출중'으로 업데이트
	public int updateStatus1(String book_isbn) {
		return session.update("library.Book.updateStatus1",book_isbn);
	}

	// 상태 '대여가능'으로 업데이트
	public int updateStatus(String book_isbn) {
		return session.update("library.Book.updateStatus2",book_isbn);
	}

	// 도서 등록
	public int insert(BookVO bookVO) {
		return session.insert("library.Book.insert",bookVO);
	}

	// 도서 삭제
	public int delete(String book_isbn) {
		return session.update("library.Book.delete", book_isbn);
	}

}
