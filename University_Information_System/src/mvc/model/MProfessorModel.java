package mvc.model;

import java.util.List;

import main.DBHelper;
import main.Department;

public class MProfessorModel extends MUser {

	private Professor[] professor;
	
	public MProfessorModel() {
		db = new DBHelper("PROFESSOR_INFO");
		selectInfo();
	}
	
	public void selectInfo() {
		List<String[]> result = db.selectAll();
		professor = new Professor[result.size()-1];
		for(int i=0; i < result.size()-1; i++) {
			String[] record = result.get(i+1);
			professor[i] = new Professor(record[0], record[1], record[2], Department.valueOf(record[3]), record[4]);
		} // 학번, 이름[1], 비밀번호[2], 학과, 주민번호
	}
	
	public Professor[] getInfo() {
		return professor;
	}
}
