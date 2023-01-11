package mini_project_library.controller.user;

import java.util.List;

import mini_project_library.service.UserService;
import mini_project_library.vo.UserVO;

public class FindAllUserController {

	public List<UserVO> getResult() {
		UserService service = new UserService();
		List<UserVO> list = service.findAllUser();
		// 여기까지는 list로 보내고, 
		// view에서 obserbavlelist로 변환시킬 꺼에요
		return list;
		
	}

}
