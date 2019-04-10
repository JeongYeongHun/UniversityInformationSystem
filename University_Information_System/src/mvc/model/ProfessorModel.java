package mvc.model;

import java.util.List;

public class ProfessorModel extends User{

	private MProfessorModel mprofessorModel;
	
	public ProfessorModel() {
		mprofessorModel = new MProfessorModel();
		this.sum = getInfo();
	}
	
	public String[][] ModelToString() {
		Professor[] professor = mprofessorModel.getInfo();
		String[][] str = new String[professor.length][5];
		for(int i = 0; i < professor.length; i++) {
			str[i][0] = professor[i].getNo();
			str[i][1] = professor[i].getName();
			str[i][2] = professor[i].getPw();
			str[i][3] = professor[i].getDept().toString();
			str[i][4] = professor[i].getJumin();
		}
		return str;
	}
	
	public boolean compare(String id) {
		if(id.charAt(0) == 'P') {
			return true;
		}
		return false;
	}
	
	public void insert(String no, String name, String pw, String dept, String jumin) {
		mprofessorModel.insertInfo(no, name, pw, dept, jumin);
	}
	
	public void delete(String column, String value) {
		mprofessorModel.deleteInfo(column, value);
	}
	
	public void update(String no, String name, String dept, String jumin) {
		mprofessorModel.update(no, name, dept, jumin);
	}
	
	public String[][] searchNo(String no) {
		List<String[]> list = mprofessorModel.searchNo(no);
		String[][] str = new String[1][5];
		if(list.size() != 1) {	//검색결과가 하나라도 있다면
			String[] record = list.get(1);
			str[0][0] = record[0];
			str[0][1] = record[1];
			str[0][2] = record[2];
			str[0][3] = record[3];
			str[0][4] = record[4];
		}
		else{
			for(int i = 0; i < 5; i++) {
				str[0][i] = "없음";
			}
		}
		return str;
	}
	
	public String[][] searchName(String name) {
		List<String[]> list = mprofessorModel.searchName(name);
		String[][] str;
		if(list.size() != 1) {	//검색결과가 하나라도 있다면
			str = new String[list.size()-1][5];
			for(int i = 0; i < list.size()-1; i++) {
				String[] record = list.get(i+1);
				str[i][0] = record[0];
				str[i][1] = record[1];
				str[i][2] = record[2];
				str[i][3] = record[3];
				str[i][4] = record[4];
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
