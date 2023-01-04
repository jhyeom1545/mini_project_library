package mini_project_library.controller.user;

import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class FindUserController {

	public UserVO getResult(String id) {
		UserService service = new UserService();
		return service.findUserByID(id);
	}
}
