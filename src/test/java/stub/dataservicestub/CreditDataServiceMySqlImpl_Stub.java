package stub.dataservicestub;

import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;

public class CreditDataServiceMySqlImpl_Stub implements CreditDataService{
	int id;
	int credit;
	
	public CreditDataServiceMySqlImpl_Stub(int i, int c) {
		// TODO Auto-generated constructor stub
		id = i;
		credit = c;
	}
	
	/**
	 * 添加信用值对象
	 */
	@Override
	public void insertCredit(CreditPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(cpo.getID()>=10000000 && cpo.getID()<=10000000){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}
	
	/**
	 * 删除信用值对象
	 */
	@Override
	public void deleteCredit(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=10000000 && id<50000000){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}
	
	/**
	 * 更新信用值对象
	 */
	@Override
	public void updateCredit(CreditPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(cpo.getID()>=10000000 && cpo.getID()<50000000){
			System.out.println("Update succeed!");
		}
		else System.out.println("Update failed!");
	}
	
	/**
	 * 查找信用值对象
	 */
	@Override
	public CreditPO findCredit(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=10000000 && id<50000000){
			return new CreditPO(id, credit);
		}
		else return null;
	}
	
	/**
	 * 初始化
	 */
	@Override
	public void initCreditDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}
	
	/**
	 * 结束
	 */
	@Override
	public void finishCreditDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}
	
}
