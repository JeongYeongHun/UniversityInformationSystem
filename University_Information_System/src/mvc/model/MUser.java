package mvc.model;

import java.util.List;

import main.DBHelper;

public abstract class MUser {
	
	protected DBHelper db;
		
	public abstract void selectInfo();
		
	public void insertInfo(String no, String name, String pw, String dept, String jumin) {
		db.insert(no, name, pw, dept, jumin);
	}
		
	public void deleteInfo(String column, String value) {
		db.delete(column, value);
	}
		
	public void update(String no, String name, String dept, String jumin) {
		db.update("no", no, "name", name);
		db.update("no", no, "deptname", dept);
		db.update("no", no, "password", jumin.substring(7));
		db.update("no", no, "r_number", jumin);
	}
	
	public List<String[]> searchNo(String no) {
		return db.search("*", "no", no);
	}
	
	public List<String[]> searchName(String name) {
		return db.search("*", "name", name);
	}
	
}
