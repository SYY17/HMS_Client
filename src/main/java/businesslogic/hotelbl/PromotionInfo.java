package businesslogic.hotelbl;

import java.util.Date;

import vo.PromotionType;

public interface PromotionInfo {

	/**
	 * 
	 * @return 获得营销策略名字
	 */
	public String getPromotionName();

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

	/**
	 * 
	 * @return 获得营销策略结束时间
	 */
	public Date getStopTime();

	/**
	 * 
	 * @return 获得营销策略类型
	 */
	public PromotionType getPromotionType();

}
