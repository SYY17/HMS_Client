package businesslogic.hotelbl;

import java.util.Date;

public interface PromorionInfo {
	/**
	 * 
	 * @return 获得营销策略内容
	 */
	public String getContent();
	
	/**
	 * 
	 * @return 获得营销策略起始时间
	 */
	public Date getStartTime();
}
