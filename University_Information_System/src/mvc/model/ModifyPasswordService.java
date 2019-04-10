package mvc.model;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class ModifyPasswordService {
	private String id;
	private String idType;
	private DBHelper db;
	
	public ModifyPasswordService(String id) {
		this.id = id;
		this.idType = idType();
	}
	
	public boolean update(String newPassword) {
		db = new DBHelper(idType);
		
		if(db.update("no", id, "password", newPassword)) {
			return true;
		}
		return false;
	}
	
	public String idType() {
		String strtype = id.substring(0, 1);
		switch(strtype.charAt(0)) {
			case 'S':
				return "STUDENT_INFO";
			case 'P':
				return "PROFESSOR_INFO";
			case 'H':
				return "DEPT_MANAGER_INFO";
			case 'G':
				return "CLASS_MANAGER_INFO";
			case 'M':
				return "MASTER";
			default:
				return null;	
		}
	}
}
