package mvc.model;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class MClassManagerModel extends MEmp{
	
	public MClassManagerModel() {
		db = new DBHelper("CLASS_MANAGER_INFO");
		selectInfo();
	}
	
}
