package mini_project_library.controller.user;

import mini_project_library.service.UserService;

public class FindUserController {

	public boolean getResult(String id) {
		UserService service = new UserService();
		return service.findUserByID(id);
	}
}
