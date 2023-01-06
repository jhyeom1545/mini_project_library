package mini_project_library.controller.user;

import javafx.collections.ObservableList;
import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class FindAllUserController {

	public ObservableList<UserVO>  getResult() {
		UserService service = new UserService();
		ObservableList<UserVO>  list = service.findAllUser(); 
		
		return list;
	}

}
