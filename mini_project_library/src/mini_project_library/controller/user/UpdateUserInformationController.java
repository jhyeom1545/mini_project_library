package mini_project_library.controller.user;

import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class UpdateUserInformationController {

	public void execute(UserVO updateUser) {
		UserService service = new UserService();
		service.userUpdate(updateUser);
	}
	
}
