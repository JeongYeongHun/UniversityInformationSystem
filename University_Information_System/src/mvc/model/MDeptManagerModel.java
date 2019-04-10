package mvc.model;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class MDeptManagerModel extends MEmp{

	public MDeptManagerModel() {
		db = new DBHelper("DEPT_MANAGER_INFO");
		selectInfo();
	}
}
