package mini_project_library.vo;

public class UserVO {
	private String user_id;
	private String user_password;
	private String user_name;
	private int user_point;

	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String user_id, String user_password, String user_name, int user_point) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_point = user_point;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_point=" + user_point + "]";
	}

}
