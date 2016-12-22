package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogic.creditbl.CreditController;
import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import businesslogicservice.loginblservice.LoginBLService;
import dataservice.creditdataservice.CreditDataService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;
import po.CreditPO;
import po.HotelPO;
import po.RoomPO;
import po.RoomType;
import po.UserPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;

public class LoginController implements LoginBLService {

	private RemoteController remoteController;
	private UserDataService userdataservice;
	private CustomerDataService customerdataservice;
	private CreditBLService creditblservice;
	private HotelDataService hoteldataservice;
	private RoomDataService roomdataservice;

	public LoginController() {
		// TODO Auto-generated constructor stub
		// 建立与服务器端的连接
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		userdataservice = remoteController.getUserDataService();
		customerdataservice = remoteController.getCustomerDataService();
		creditblservice = new CreditController();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param id
	 * @return 增加新用户
	 */
	@Override
	public ResultMessage addNewUser(String username, String password, int id) {
		// TODO Auto-generated method stub
		try {
			userdataservice.initUserDataService();
			UserPO user = userdataservice.findUser(username);

			// 如果user数据不为空，表示已有该用户信息，直接返回注册失败
			if (user != null) {
				return ResultMessage.FALSE;
			}

			user = new UserPO(id, username, password);
			userdataservice.insertUser(user);
			int userID = userdataservice.findUser(username).getID();
			userdataservice.finishUserDataService();

			if (10000000 <= userID && userID < 20000000) {
				customerdataservice.initCustomerDataService();
				customerdataservice.insertCustomer(username);
				customerdataservice.finishCustomerDataService();

				creditblservice.addCredit(userID, 0);
			} else if (20000000 <= userID && userID < 30000000) {
				hoteldataservice.initHotelDataService();
				hoteldataservice.insertHotel(new HotelPO(id, "", "", "", "", 0, 0, "", ""));
				hoteldataservice.finishHotelDataService();

				roomdataservice.initRoomDataService();
				roomdataservice.insertRoom(new RoomPO(userID, RoomType.SINGLE_ROOM, 0, 0, 0));
				roomdataservice.insertRoom(new RoomPO(userID, RoomType.STANDARD_ROOM, 0, 0, 0));
				roomdataservice.insertRoom(new RoomPO(userID, RoomType.SUITE, 0, 0, 0));
				roomdataservice.insertRoom(new RoomPO(userID, RoomType.TRIPLE_ROOM, 0, 0, 0));
				roomdataservice.insertRoom(new RoomPO(userID, RoomType.KING_SIZE_ROOM, 0, 0, 0));
				roomdataservice.finishRoomDataService();
			}
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 *            * @param id
	 * @return 登录
	 */
	@Override
	public ResultMessage login(String username, String password, int id) {
		// TODO Auto-generated method stub
		try {
			userdataservice.initUserDataService();
			UserPO user = userdataservice.findUser(username);
			userdataservice.finishUserDataService();

			if (user == null)
				return ResultMessage.FALSE;

			if (user.getPassword().equals(password) && (user.getID() / 10000000 == id)) {
				return ResultMessage.TRUE;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 *            * @param id
	 * @return 注销
	 */
	@Override
	public ResultMessage logout(String username) {
		// TODO Auto-generated method stub
		if (username != null) {
			return ResultMessage.TRUE;
		}

		return ResultMessage.FALSE;
	}

}
