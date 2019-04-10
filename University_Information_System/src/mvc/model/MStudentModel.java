package mvc.model;

import java.util.List;

import main.DBHelper;
import main.Department;

public class MStudentModel extends MUser {
	
	private Student[] student;
	
	public MStudentModel() {
		db = new DBHelper("STUDENT_INFO");
		selectInfo();
	}
	
	public void selectInfo() {
		List<String[]> result = db.selectAll();
		student = new Student[result.size()-1];
		for(int i=0; i < result.size()-1; i++) {
			String[] record = result.get(i+1);
			student[i] = new Student(record[0], record[2], record[1], Department.valueOf(record[3]), record[4]);
		} // 학번, 이름[2], 비밀번호[1], 학과, 주민번호
	}
	
	public Student[] getInfo() {
		return student;
	}
}
