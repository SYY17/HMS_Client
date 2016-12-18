package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.fullcutpromotiondataservice.FullCutPromotionDataService;
import po.FullCutPromotionPO;
import po.PromotionType;
import rmi.RemoteController;

public class DataServiceClientRunner {
	private RemoteController remoteController;

	/**
	 * 
	 * @return 获得remoteController对象
	 */
	public RemoteController getRemoteController() {
		return remoteController;
	}

	/**
	 * 提供给外界的启动数据服务的方法
	 */
	public void start() { 
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

	public static void main(String[] args) {
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		// cr.test();
		RemoteController rc = cr.getRemoteController();
		try {
			FullCutPromotionDataService fc = rc.getFullCutPromotionDataService();
			fc.initFullCutPromotionDataService();
			fc.insertFullCutPromotion(new FullCutPromotionPO("Sixth","SixthPromotion",Date.valueOf("2016-12-01"),Date.valueOf("2016-12-31"),PromotionType.FULL_CUT,20902341,200,20));
			ArrayList<FullCutPromotionPO> list = fc.findsFullPromotion(20902341);
			System.out.println(list.get(0).getContent());
			fc.finishFullCutPromotionDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
