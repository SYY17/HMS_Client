package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import po.UserPO;
import rmi.RemoteController;

public class DataServiceClientRunner {
	private RemoteController remoteController;
	
	/**
	 * 
	 * @return 获得remoteController对象
	 */
	public RemoteController getRemoteController(){
		return remoteController;
	}
	
	/**
	 * 提供给外界的启动数据服务的方法
	 */
	public void start(){
		linkToServer();
	}
	
	/**
	 * 内部对于链接到服务器的实现
	 */
	private void linkToServer() {
		try {
			remoteController = RemoteController.getInstance();
			remoteController.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		//cr.test();
		RemoteController rc = cr.getRemoteController();
		try {
			rc.getUserDataService().initUserDataService();
			UserPO user = rc.getUserDataService().findUser("张三");
			if(user != null){
				System.out.print("User ID: "+user.getID()+"; ");
				System.out.print("User Name: "+user.getName()+"; ");
				System.out.println("User Password: "+user.getPassword());
			}
			rc.getUserDataService().finishUserDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
