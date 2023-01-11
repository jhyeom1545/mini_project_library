package mini_project_library.controller.user;

import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class CreateUserController {

	public int execute(UserVO user) {
		UserService service = new UserService();
		return service.createUser(user);
	}
}
