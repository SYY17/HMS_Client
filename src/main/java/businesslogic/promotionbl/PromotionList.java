package businesslogic.promotionbl;

import java.util.ArrayList;
import java.sql.Date;

import vo.PromotionVO;

public class PromotionList {
	
	ArrayList<PromotionLineItem> list;
	
	/**
	 * 
	 * @param list
	 */
	public void setPromotionList(ArrayList<PromotionLineItem> list){
		this.list = list;
	}
	
	/**
	 * 
	 * @return 获得营销策略列表
	 */
	public ArrayList<PromotionLineItem> getPromotionList(){
		return list;
	}
	
	/**
	 * 
	 * @param promotionLineItem
	 */
	public void addPromotionLineItem(PromotionLineItem promotionLineItem){
		list.add(promotionLineItem);
	}
	
	/**
	 * 
	 * @param promotionLineItem
	 */
	public void deletePromotionLineItem(PromotionLineItem promotionLineItem){
		for(int i=0; i<list.size(); i++){
			if(promotionLineItem.isEquals(list.get(i))){
				list.remove(i);
				break;
			}
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param content
	 * @return 按照内容查找营销策略
	 */
	public PromotionVO findPromotionLineItemByContent(int id, String content){
		PromotionLineItem promotionLineItem;
		for(int i=0; i<list.size(); i++){
			promotionLineItem = list.get(i);
			if(promotionLineItem.getContent().equals(content)&&promotionLineItem.getID()==id){
				return this.converse(promotionLineItem);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @param start
	 * @return 按照起始时间查找营销策略
	 */
	public PromotionVO findPromotionLineItemByStartTime(int id, Date start){
		PromotionLineItem promotionLineItem;
		for(int i=0; i<list.size(); i++){
			promotionLineItem = list.get(i);
			if(promotionLineItem.getStartTime().equals(start)&&promotionLineItem.getID()==id){
				return this.converse(promotionLineItem);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param promotionLineItem
	 * @return 将营销策略项转换为VO对象
	 */
	private PromotionVO converse(PromotionLineItem promotionLineItem){
		String ctt = promotionLineItem.getContent();
		Date s = promotionLineItem.getStartTime();
		int i = promotionLineItem.getID();
		return new PromotionVO(ctt,s,i);
	}
	
	/**
	 * 
	 * @param promotionLineItem
	 * @return 精确查找营销策略
	 */
	public boolean hasPromotionLineItem(PromotionLineItem promotionLineItem){
		for(int i=0; i<list.size(); i++){
			if(promotionLineItem.isEquals(list.get(i))){
				return true;
			}
		}
		return false;
	}
}
