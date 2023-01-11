package mini_project_library.controller.user;

import mini_project_library.service.UserService;
import mini_project_library.vo.LoginVO;
import mini_project_library.vo.UserVO;

public class UserLoginController {

	public UserVO execute(LoginVO user) {
		UserService service = new UserService();
		return service.getLogin(user);
	}
}
