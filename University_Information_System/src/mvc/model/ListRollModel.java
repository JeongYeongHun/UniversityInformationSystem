package mvc.model;

import java.util.List;

import main.DBHelper;
import main.Department;

public class ListRollModel {
	private ListRollInfo[] listrollinfo;
	private DBHelper db;
	private List<String[]> arr;
	
	public ListRollModel(String classNum) {
		db = new DBHelper("student_info s join register_info r on r.stud_no = s.no");
		arr = db.search("*","class_no",classNum);
		matching();
	}
	
	public void matching() {
		if((arr.size()-1) > 0) {
			listrollinfo = new ListRollInfo[arr.size()-1];
		}
		else {
			listrollinfo = new ListRollInfo[1];
			listrollinfo[0] = new ListRollInfo();
			listrollinfo[0].setNo("없음");
			listrollinfo[0].setName("없음");
			listrollinfo[0].setChargeDept(Department.valueOf("전산학과"));
			listrollinfo[0].setPassword("없음");
			listrollinfo[0].setRNumber("없음");
			listrollinfo[0].setClassNo("없음");
			listrollinfo[0].setStudNo("없음");
			listrollinfo[0].setScore("없음");
		}
		
		for(int i = 0; i < (arr.size()-1); i++) {
			String[] record = arr.get(i+1);
			listrollinfo[i] = new ListRollInfo();
			listrollinfo[i].setNo(record[0]);
			listrollinfo[i].setName(record[1]);
			listrollinfo[i].setScore(record[7]);
			listrollinfo[i].setPassword(record[2]);
			listrollinfo[i].setChargeDept(Department.valueOf(record[3]));
			listrollinfo[i].setRNumber(record[4]);
			listrollinfo[i].setClassNo(record[5]);
			listrollinfo[i].setStudNo(record[6]);
		}
	}
	
	public void insertScore(String classNum, String id, String score) {
		db = new DBHelper("register_info");
		db.update("class_no = '" + classNum + "' and stud_no", id, "score", score);
	}

	public ListRollInfo[] getListRollinfo() {
		return listrollinfo;
	}
	
}
