package mini_project_library.controller.point;

import mini_project_library.service.PointService;

public class AddPointToUserController {

	public void getResult(String user_id) {
		PointService service = new PointService();
		service.addPointToUser(user_id);
		
	}
	
	
}
