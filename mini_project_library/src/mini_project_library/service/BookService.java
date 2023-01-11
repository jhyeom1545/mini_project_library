package mini_project_library.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini_project_library.dao.BookDAO;
import mini_project_library.mybatis.MyBatisConnectionFactory;
import mini_project_library.vo.BookVO;

public class BookService {
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public List<BookVO> bookSearchByKeyword(String keyword) {
		SqlSession session = factory.openSession();
		BookDAO dao = new BookDAO(session);
		List<BookVO> list = dao.selectByKeyword(keyword);
		return list;

	}

	public int createBook(BookVO book) {
		int result = 0;
		SqlSession session = factory.openSession();
		BookDAO dao = new BookDAO(session);

		try {
			result = dao.insert(book);
			if (result == 1) {
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

	public int BookUpdate(BookVO bookVO) {
		int result = 0;
		SqlSession session = factory.openSession();
		BookDAO dao = new BookDAO(session);
		System.out.println(bookVO);
		try {
			result = dao.update(bookVO);
			if (result == 1) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	public int deleteBook(String book_isbn) {
		int result = 0;
		SqlSession session = factory.openSession();
		BookDAO dao = new BookDAO(session);
		try {
			result = dao.delete(book_isbn);
			if (result == 1) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
}
