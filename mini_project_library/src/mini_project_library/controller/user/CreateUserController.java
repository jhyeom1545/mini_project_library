package mini_project_library.controller.user;

import mini_project_library.service.UserService;

public class CreateUserController {
	public int createUser(String id, String pw, String name) {
		UserService service = new UserService();
		return service.createuser(id, pw, name);
	}
}
