package presentation.controller;

public class TempIDHelper {

	// 单件模式
	private static TempIDHelper idHelper;
	private static int id;

	private TempIDHelper() {

	}

	public void setID(int id) {
		TempIDHelper.id = id;
	}

	public static TempIDHelper getInstance() {
		if (idHelper == null) {
			idHelper = new TempIDHelper();
		}
		return idHelper;
	}

	public int getID() {
		return id;
	}
}
