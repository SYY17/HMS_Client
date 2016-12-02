package businesslogic.promotionbl;

import java.sql.Date;

import po.PromotionPO;

public class PromotionLineItem {
	
	String content = null;
	Date start = null;
	int id = 0;
	
	public PromotionLineItem(String ctt, Date s, int i){
		content = ctt;
		start = s;
		id = i;
	}
	
	public PromotionLineItem(PromotionPO ppo){
		content = ppo.getContent();
		start = ppo.getStartTime();
		id = ppo.getID();
	}
		
	/**
	 * 
	 * @return 获得营销策略内容
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * 
	 * @param content
	 */
	public void setContent(String ctt){
		content = ctt;
	}
	
	/**
	 * 
	 * @return 获得营销策略起始时间
	 */
	public Date getStartTime(){
		return start;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setStartTime(Date s){
		start = s;
	}
	
	/**
	 * 
	 * @return 获得营销策略制定者ID
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * 
	 * @param i
	 */
	public void setID(int i){
		id = i;
	}
	
	/**
	 * 
	 * @param promotionLineItem
	 * @return 判断是否是相同的营销策略项
	 */
	public boolean isEquals(PromotionLineItem promotionLineItem){
		String ctt = promotionLineItem.getContent();
		Date s = promotionLineItem.getStartTime();
		int i = promotionLineItem.getID();
		if(ctt.equals(content)&&s.equals(start)&&i==id){
			return true;
		}
		return false;
	}
}
