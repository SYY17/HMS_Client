package businesslogic.customerbl;

import java.rmi.RemoteException;

import businesslogicservice.customerBLService.CustomerBLService;
import dataservice.customerdataservice.CustomerDataService;
import po.CustomerPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.CustomerVO;

public class CustomerController implements CustomerBLService{

	private RemoteController remoteController;
	private CustomerDataService customerDataService;
	
	public CustomerController() {
		// TODO Auto-generated constructor stub
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		customerDataService = remoteController.getCustomerDataService();
		
	}
	
	/**
	 * 
	 * @param username
	 * @return 根据用户名查找并返回顾客信息
	 * @throws RemoteException
	 */
	@Override
	public CustomerVO getCustomerInfo(String username) {
		// TODO Auto-generated method stub
		CustomerVO cvo = null;
		
		try {
			customerDataService.initCustomerDataService();
			CustomerPO cpo = customerDataService.getCustomerInfo(username);
			customerDataService.finishCustomerDataService();
			
			cvo = this.convert(cpo);
			return cvo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cvo;
	}
	
	/**
	 * 
	 * @param cvo
	 * @return 更新顾客信息
	 * @throws RemoteException
	 */
	@Override
	public boolean setCustomerInfo(CustomerVO cvo){
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			CustomerPO cpo = this.convert(cvo);
			customerDataService.initCustomerDataService();
			result = customerDataService.updateCustomerInfo(cpo);
			customerDataService.finishCustomerDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param cpo
	 * @return VO, PO转换方法
	 */
	private CustomerVO convert(CustomerPO cpo){
		CustomerVO cvo = new CustomerVO(cpo.getID(), cpo.getName(), cpo.getPassword(), cpo.getBirthday(), cpo.getPhoneNumber(), cpo.getEmail(), cpo.getAddress());
		return cvo;
	}
	
	/**
	 * 
	 * @param cvo
	 * @return PO, VO转换方法
	 */
	private CustomerPO convert(CustomerVO cvo){
		CustomerPO cpo = new CustomerPO(cvo.getID(), cvo.getName(), cvo.getPassword(), cvo.getBirthday(), cvo.getPhoneNumber(), cvo.getEmail(), cvo.getAddress());
		return cpo;
	}
	
}
