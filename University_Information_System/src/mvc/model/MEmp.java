package mvc.model;

import java.util.List;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public abstract class MEmp {
	protected DBHelper db;
	protected Employee[] employee;
	
	public void insertInfo(String name, String no, String rnum) {
		db.insert(no, name, rnum.substring(7), rnum);	//주민등록번호 뒷자리 7자리를 자동으로 비밀번호 등록
	}
	
	public void deleteInfo(String column, String value) {
		db.delete(column, value);
	}
	
	public void update(String name, String no, String rnum) {
		db.update("no", no, "name", name);
		db.update("no", no, "password", rnum.substring(7));
		db.update("no", no, "rnumber", rnum);
	}
	
	public void selectInfo() {
		List<String[]> result = db.selectAll();
		employee = new Employee[result.size()-1];
		for(int i = 0; i < result.size()-1; i++) {
			String[] record = result.get(i+1);
			employee[i] = new Employee(record[1], record[0], record[2], record[3]);	//이름, 직원번호, 비밀번호, 주민번호 순서
		}
	}
	
	public Employee[] getInfo() {
		return employee;
	}
}
