package mvc.model;

import java.util.List;

public class StudentModel extends User {

	private MStudentModel mstudentModel;
	
	public StudentModel() {
		mstudentModel = new MStudentModel();
		this.sum = getInfo();
	}
	
	public String[][] ModelToString() {
		Student[] student = mstudentModel.getInfo();
		String[][] str = new String[student.length][5];
		for(int i = 0; i < student.length; i++) {
			str[i][0] = student[i].getNo();
			str[i][1] = student[i].getName();
			str[i][2] = student[i].getPw();
			str[i][3] = student[i].getDept().toString();
			str[i][4] = student[i].getJumin();
		}
		return str;
	}
	
	public boolean compare(String id) {
		if(id.charAt(0) == 'S') {
			return true;
		}
		return false;
	}
	
	public void insert(String no, String name, String pw, String dept, String jumin) {
		mstudentModel.insertInfo(no, name, pw, dept, jumin);
	}
	
	public void delete(String column, String value) {
		mstudentModel.deleteInfo(column, value);
	}

	public void update(String no, String name, String dept, String jumin) {
		mstudentModel.update(no, name, dept, jumin);
	}
	
	public String[][] searchNo(String no) {
		List<String[]> result = mstudentModel.searchNo(no);
		String[][] str = new String[1][5];
		if(result.size() != 1) {	//검색결과가 하나라도 있다면
			String[] row = result.get(1);
			str[0][0] = row[0];
			str[0][1] = row[1];
			str[0][2] = row[2];
			str[0][3] = row[3];
			str[0][4] = row[4];
		}
		else{
			for(int i = 0; i < 5; i++) {
				str[0][i] = "없음";
			}
		}
		return str;
	}
	
	public String[][] searchName(String name) {
		List<String[]> result = mstudentModel.searchName(name);
		String[][] str;
		if(result.size() != 1) {	//검색결과가 하나라도 있다면
			str = new String[result.size()-1][5];
			for(int i = 0; i < result.size()-1; i++) {
				String[] row = result.get(i+1);
				str[i][0] = row[0];
				str[i][1] = row[1];
				str[i][2] = row[2];
				str[i][3] = row[3];
				str[i][4] = row[4];
			}
		}
		else {
			str = new String[1][5];
			for(int i = 0; i < 5; i++) {
				str[0][i] = "없음";
			}
		}
		return str;
	}


}
