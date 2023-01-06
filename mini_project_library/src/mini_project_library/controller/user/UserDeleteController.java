package mini_project_library.controller.user;

import mini_project_library.service.UserService;

public class UserDeleteController {

	public int getResult(String user_id) {
		UserService service = new UserService();
		return service.userDelete(user_id);
	}

}
