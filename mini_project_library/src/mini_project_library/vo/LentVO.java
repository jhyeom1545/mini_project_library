package mini_project_library.vo;

public class LentVO {
	private String lent_id;
	private String book_isbn;
	private String book_title;
	private String book_date;
	private String book_author;
	private String book_publisher;
	private String book_lent_date;
	private String book_return_date;
	private String book_lent_satus;
	private String book_actual_return_date;
	
	public String getBook_lent_satus() {
		return book_lent_satus;
	}

	public void setBookß_lent_satus(String book_lent_satus) {
		this.book_lent_satus = book_lent_satus;
	}

	public String getBook_actual_return_date() {
		return book_actual_return_date;
	}

	public void setBook_actual_return_date(String book_actual_return_date) {
		this.book_actual_return_date = book_actual_return_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private String user_id;
	
	public LentVO() {
		// TODO Auto-generated constructor stub
	}
	
	public LentVO(String lent_id, String book_isbn, String book_title, String book_date, String book_author, String book_publisher,
			String book_lent_date, String book_return_date) {
		super();
		this.lent_id = lent_id;
		this.book_isbn = book_isbn;
		this.book_title = book_title;
		this.book_date = book_date;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_lent_date = book_lent_date;
		this.book_return_date = book_return_date;
	}
	

	public String getLent_id() {
		return lent_id;
	}

	public void setLent_id(String lent_id) {
		this.lent_id = lent_id;
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
	public String getBook_date() {
		return book_date;
	}
	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
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

	@Override
	public String toString() {
		return "LentVO [lent_id=" + lent_id + ", book_isbn=" + book_isbn + ", book_title=" + book_title + ", book_date="
				+ book_date + ", book_author=" + book_author + ", book_publisher=" + book_publisher
				+ ", book_lent_date=" + book_lent_date + ", book_return_date=" + book_return_date + "]";
	}


	
}
