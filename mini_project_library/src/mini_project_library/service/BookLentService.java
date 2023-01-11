package mini_project_library.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini_project_library.dao.BookDAO;
import mini_project_library.dao.BookLentDAO;
import mini_project_library.mybatis.MyBatisConnectionFactory;
import mini_project_library.vo.BookLentVO;
import mini_project_library.vo.InsertLentBookVO;
import mini_project_library.vo.LentVO;

public class BookLentService {
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	// 도서 대여 기록 생성
	public int bookLentByISBN(InsertLentBookVO insertLentBook) {
		SqlSession session = factory.openSession();
		BookLentDAO dao = new BookLentDAO(session);
		BookDAO bookDao = new BookDAO(session);
		int bookLentResult = 0;
		int bookUpdateResult = 0;
		try {
			bookLentResult = dao.insert(insertLentBook);
			bookUpdateResult = bookDao.updateStatus1(insertLentBook.getbook_isbn());

			if (bookLentResult == bookUpdateResult) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			session.close();
		}
		return bookLentResult;
	}

	//
	public List<LentVO> lentBookSearchByUserID(String user_id) {
		SqlSession session = factory.openSession();
		BookLentDAO dao = new BookLentDAO(session);
		List<LentVO> result = dao.selectByUserID(user_id);
		session.close();

		return result;
	}

	// 도서 반납
	public int LentBookReturnByISBN(LentVO lentBook) {
		int lentBookResult = 0;
		SqlSession session = factory.openSession();
		BookLentDAO dao = new BookLentDAO(session);
		BookDAO bookDAO = new BookDAO(session);
		try {
			lentBookResult = dao.update(lentBook);
			
			int updateBookLent = bookDAO.updateStatus(lentBook.getBook_isbn());
			if (updateBookLent == 1 && lentBookResult == 1) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return lentBookResult;
	}

	public List<BookLentVO> findBookLentList() {
		SqlSession session = factory.openSession();
		BookLentDAO dao = new BookLentDAO(session);
		List<BookLentVO> result = null;
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
