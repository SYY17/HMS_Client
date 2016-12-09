package businesslogic.promotionbl;

import java.sql.Date;

import po.PromotionPO;
import po.PromotionType;

public class PromotionLineItem {

	String promotionName;
	String content = null;
	Date start = null;
	Date stop = null;
	PromotionType promotionType;
	int id = 0;

	public PromotionLineItem(String pn, String ctt, Date s, Date sp, PromotionType pt, int i) {
		promotionName = pn;
		content = ctt;
		start = s;
		stop = sp;
		promotionType = pt;
		id = i;
	}

	public PromotionLineItem(PromotionPO ppo) {
		promotionName = ppo.getPromotionName();
		content = ppo.getContent();
		start = ppo.getStartTime();
		stop = ppo.getStopTime();
		promotionType = ppo.getPromotionType();
		id = ppo.getID();
	}

	/**
	 * 
	 * @return 获得营销名字
	 */
	public String getPromotionName() {
		return promotionName;
	}

	/**
	 * 
	 * @param content
	 */
	public void setPromotionName(String pn) {
		promotionName = pn;
	}

	/**
	 * 
	 * @return 获得营销策略内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 
	 * @param content
	 */
	public void setContent(String ctt) {
		content = ctt;
	}

	/**
	 * 
	 * @return 获得营销策略起始时间
	 */
	public Date getStartTime() {
		return start;
	}

	/**
	 * 
	 * @param s
	 */
	public void setStartTime(Date s) {
		start = s;
	}

	/**
	 * 
	 * @return 获得营销策略起始时间
	 */
	public Date getStopTime() {
		return stop;
	}

	/**
	 * 
	 * @param s
	 */
	public void setStopTime(Date sp) {
		stop = sp;
	}

	/**
	 * 
	 * @return 获得营销策略类型
	 */
	public PromotionType getPromotionType() {
		return promotionType;
	}

	/**
	 * 
	 * @param pt
	 */
	public void setPromotionType(PromotionType pt) {
		promotionType = pt;
	}

	/**
	 * 
	 * @return 获得营销策略制定者ID
	 */
	public int getID() {
		return id;
	}

	/**
	 * 
	 * @param i
	 */
	public void setID(int i) {
		id = i;
	}

	/**
	 * 
	 * @param promotionLineItem
	 * @return 判断是否是相同的营销策略项
	 */
	public boolean isEquals(PromotionLineItem promotionLineItem) {
		String pn = promotionLineItem.getPromotionName();
		String ctt = promotionLineItem.getContent();
		Date s = promotionLineItem.getStartTime();
		Date sp = promotionLineItem.getStopTime();
		PromotionType pt = promotionLineItem.getPromotionType();
		int i = promotionLineItem.getID();
		if (pn.equals(promotionName) && ctt.equals(content) && s.equals(start) && sp.equals(stop)
				&& pt.equals(promotionType) && i == id) {
			return true;
		}
		return false;
	}
}
