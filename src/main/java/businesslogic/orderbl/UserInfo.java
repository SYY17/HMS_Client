package businesslogic.orderbl;

public interface UserInfo {

	/**
	 * 
	 * @param userName
	 * @return 根据用户ID查找并返回用户名
	 */
	public String searchByUserID(int id);
	
	/**
	 * 
	 * @param id
	 * @return 根据用户名查找并返回ID
	 */
	public int searchByUserName(String userName);
}
