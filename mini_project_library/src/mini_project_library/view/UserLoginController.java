package mini_project_library.view;

import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class UserLoginController {

	public UserVO getResult(String user_id, String user_password) {
		UserService service = new UserService();
		return service.getLogin(user_id, user_password);
	}
}
