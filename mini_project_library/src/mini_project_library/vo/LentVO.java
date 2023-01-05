package mini_project_library.vo;

public class LentVO {
	
	private String book_isbn;
	private String book_title;
	private String book_date;
	private String book_author;
	private String book_publisher;
	private String book_lent_date;
	private String book_return_date;
	
	public LentVO() {
		// TODO Auto-generated constructor stub
	}
	
	public LentVO(String book_isbn, String book_title, String book_date, String book_author, String book_publisher,
			String book_lent_date, String book_return_date) {
		super();
		this.book_isbn = book_isbn;
		this.book_title = book_title;
		this.book_date = book_date;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_lent_date = book_lent_date;
		this.book_return_date = book_return_date;
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
	
}
