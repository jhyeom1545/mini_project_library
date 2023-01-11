package mini_project_library.vo;

public class InsertLentBookVO {

	private String book_isbn;
	private String user_id;
	
	public InsertLentBookVO() {
		// TODO Auto-generated constructor stub
	}
	
	public InsertLentBookVO(String book_isbn, String user_id) {
		this.book_isbn = book_isbn;
		this.user_id = user_id;
	}
	
	

	public String getbook_isbn() {
		return book_isbn;
	}

	public void setbook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
