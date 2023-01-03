package mini_project_library.vo;

public class BookVO {
	String bisbn;
	String btitle;
	String bdate;
	int bpage;
	String bauthor;
	
	public BookVO() {
		// TODO Auto-generated constructor stub
	}

	public BookVO(String bisbn, String btitle, String bdate, int bpage, String bauthor) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bauthor = bauthor;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	
	
	
}
