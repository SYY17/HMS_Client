package presentation.controller;

public class IDHelper {
	
	//单件模式
	private static IDHelper idHelper;
	private static int id;
	
	private IDHelper(){
		
	}
	
	public void initialID(int id){
		IDHelper.id = id;
	}
	
	public static IDHelper getInstance(){
		if(idHelper == null){
			idHelper = new IDHelper();
		}
		return idHelper;
	}
	
	public int getID(){
		return id;
	}
}
