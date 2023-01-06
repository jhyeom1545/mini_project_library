package mini_project_library.controller.user;

import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class UpdateUserInformationController {

	public void getResult(UserVO updateUser) {
		UserService service = new UserService();
		service.userInformationUpdate(updateUser);
	}
	
}
