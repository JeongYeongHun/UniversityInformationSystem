package mvc.model;

import main.Department;

/**
 * @author 정영훈
 *
 */

public abstract class User {
	
	protected String[][] sum;
	
	public String[][] getInfo() {
		String[][] str = ModelToString();
		sum = new String[str.length][5];
		for(int i= 0; i < str.length; i++) {
			sum[i] = str[i];
		}
		return sum;
	}
	
	public abstract String[][] ModelToString();
	
	public boolean compareSpace(String id, String pw, String name, String dept, String jumin) {
		if("".equals(id) || "".equals(pw) || "".equals(name) || "".equals(dept) || "".equals(jumin)) {
			return false;
		}
		return true;
	}
	
	public boolean compareSpace(String id, String name, String dept, String jumin) {
		if("".equals(id) || "".equals(name) || "".equals(dept) || "".equals(jumin)) {
			return false;
		}
		return true;
	}
	
	public boolean deptCheck(String dept) {
		for(Department d : Department.values()) {
			if(d.toString().equals(dept) && !"non".equals(dept)) {
				return true;	//과가 존재
			}
		}
		return false;	//과가 존재하지 않음
	}
	
	public abstract boolean compare(String id);
	
	public boolean checkID(String id) {
		for(int i = 0; i < sum.length; i++) {
			if(sum[i][0].equals(id)) {
				return false;	//아이디 존재
			}
		}
		return true;	//아이디가 존재하지 않음
	}
	
	public abstract void insert(String no, String name, String pw, String dept, String jumin);
	
	public abstract void delete(String column, String value);

	public abstract void update(String no, String name, String dept, String jumin);
	
	public abstract String[][] searchNo(String no);
	
	public abstract String[][] searchName(String name);
}
