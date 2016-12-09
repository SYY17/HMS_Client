package presentation.userui;

import java.util.ArrayList;
import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Driver {

	public void drive(UserBLService userBLService) {
		UserVO uvo = new UserVO(0, null, null);
		int id = 0;
		ResultMessage resultMessage = userBLService.addUser(uvo);
		if (resultMessage == ResultMessage.TRUE)
			System.out.println("User added!");
		resultMessage = userBLService.deleteUser(id);
		if (resultMessage == ResultMessage.TRUE)
			System.out.println("User deleted!");
		resultMessage = userBLService.modifyUser(uvo);
		if (resultMessage == ResultMessage.TRUE)
			System.out.println("User modified!");
		UserVO user = userBLService.searchByUserName("");
		if (user != null)
			System.out.println("User with certain id got!");
		ArrayList<UserVO> list = userBLService.getAllUsers();
		if (list != null)
			System.out.println("All Users got!");
	}
}
