//package stub.blservicestub;
//
//import java.util.ArrayList;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.userblservice.UserBLService;
//import vo.UserVO;
//
//public class UserBLService_Stub implements UserBLService{
//	int id;
//	String name;
//	String password;
//	
//	public UserBLService_Stub(int i,String n,String p){
//		id=i;
//		name=n;
//		password=p;
//	}
//	
//	@Override
//	public ResultMessage addUser(UserVO uvo) {
//		// TODO Auto-generated method stub
//		if(uvo!=null){
//			return ResultMessage.TRUE;
//		}else
//			return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage deleteUser(UserVO uvo) {
//		// TODO Auto-generated method stub
//		if(uvo!=null){
//			return ResultMessage.TRUE;
//		}else
//			return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage modifyUser(UserVO uvo) {
//		// TODO Auto-generated method stub
//		if(uvo!=null){
//			return ResultMessage.TRUE;
//		}else
//			return ResultMessage.FALSE;
//	}
//
//	@Override
//	public UserVO searchByID(int id) {
//		// TODO Auto-generated method stub
//		UserVO user=new UserVO();
//		return user;
//	}
//
//	@Override
//	public ArrayList<UserVO> searchByKeywords(String keywords) {
//		// TODO Auto-generated method stub
//		ArrayList<UserVO> UserList = new ArrayList<>();
//		UserList.add(new UserVO(0,null,null));
//		return UserList;
//	}
//
//	@Override
//	public ArrayList<UserVO> getAllUsers() {
//		// TODO Auto-generated method stub
//		ArrayList<UserVO> userList=new ArrayList<UserVO>();
//		return userList;
//	}
//
//}
//
//
//
//
