package mini_project_library.vo;

public class BookLentVO {

	private String lent_id;
	private String book_lent_status;
	private String book_lent_date;
	private String book_return_date;
	private String book_actural_return_date;
	private String book_isbn;
	private String book_title;
	private String user_id;
	
	
	
	public String getLent_id() {
		return lent_id;
	}

	public void setLent_id(String lent_id) {
		this.lent_id = lent_id;
	}

	public String getBook_lent_status() {
		return book_lent_status;
	}

	public void setBook_lent_status(String book_lent_status) {
		this.book_lent_status = book_lent_status;
	}

	public String getBook_lent_date() {
		return book_lent_date;
	}

	public void setBook_lent_date(String book_lent_date) {
		this.book_lent_date = book_lent_date;
	}

	public String getBook_return_date() {
		return book_return_date;
	}

	public void setBook_return_date(String book_return_date) {
		this.book_return_date = book_return_date;
	}

	public String getBook_actural_return_date() {
		return book_actural_return_date;
	}

	public void setBook_actural_return_date(String book_actural_return_date) {
		this.book_actural_return_date = book_actural_return_date;
	}

	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public BookLentVO(String lent_id, String book_lent_status, String book_lent_date, //
			String book_return_date, String book_actural_return_date, String book_isbn, String book_title,
			String user_id) {
		this.lent_id = lent_id;
		this.book_lent_status = book_lent_status;
		this.book_lent_date = book_lent_date;
		this.book_return_date = book_return_date;
		this.book_actural_return_date = book_actural_return_date;
		this.book_isbn = book_isbn;
		this.book_title = book_title;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "BookLentVO [lent_id=" + lent_id + ", book_lent_status=" + book_lent_status + ", book_lent_date="
				+ book_lent_date + ", book_return_date=" + book_return_date + ", book_actural_return_date="
				+ book_actural_return_date + ", book_isbn=" + book_isbn + ", book_title=" + book_title + ", user_id="
				+ user_id + "]";
	}
	
}
