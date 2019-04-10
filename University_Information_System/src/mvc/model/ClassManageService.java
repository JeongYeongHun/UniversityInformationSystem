package mvc.model;

import main.DBHelper;
import main.Department;

/**
 * @author 정영훈
 *
 */

public class ClassManageService {

	private ClassModel classModel;
	private String[][] str;
	private String[] strinfo;
	private DBHelper db;
	private String classNum;
	
	public ClassManageService() {
		db = new DBHelper("CLASS_INFO");
		classNum = "class_no";
		classModel = new ClassModel();
		modelToString();
	}
	
	public void modelToString() {
		ClassInfo[] classInfo = classModel.getClassinfo();
		
		str = new String[classInfo.length][9];
		strinfo = new String[classInfo.length];
		
		for(int i = 0; i < classInfo.length; i++) {
			str[i][0] = classInfo[i].getClassNo();
			str[i][1] = classInfo[i].getClassName();
			str[i][2] = classInfo[i].getChargeDept().toString();
			str[i][3] = String.valueOf(classInfo[i].getScore());
			str[i][4] = Character.toString(classInfo[i].getOpenChk());
			str[i][5] = classInfo[i].getChargeProf();
			str[i][6] = String.valueOf(classInfo[i].getMinStud());
			str[i][7] = String.valueOf(classInfo[i].getMaxStud());
			str[i][8] = String.valueOf(classInfo[i].getPresentStud());
			strinfo[i] = classInfo[i].getInfo();
		}
	}
	
	public boolean checkClass(String classno) {
		for(int i = 0; i < str.length; i++) {
			if(str[i][0].equals(classno)) {
				return true;
			}
		}
		return false;
	}
	
	public String[][] getStr(){
		return str;
	}
	
	public String[] getStrinfo() {
		return strinfo;
	}
	
	public ClassModel getClassModel() {
		return classModel;
	}
	
	public void insertClass (String classNo, String className, String chargeDept, String score, String info) {
		db.insert(classNo, className, chargeDept, score, info, "0", "0", "0", "0", "0");
	}
	
	public void updateClass (String classNo, String className, String chargeDept, String score, String info) {
		db.update(classNum, classNo, "class_name", className);
		db.update(classNum, classNo, "charge_dept", chargeDept);
		db.update(classNum, classNo, "score", score);
		db.update(classNum, classNo, "info", info);
	}
	
	public void deleteClass (String column, String value) {
		db.delete(column, value);
	}
	
	public void openClass (String classNo, String chargeProf, String minStud, String maxStud) {
		db.update(classNum, classNo, "charge_prof", chargeProf);
		db.update(classNum, classNo, "min_stud", minStud);
		db.update(classNum, classNo, "max_stud", maxStud);
		db.update(classNum, classNo, "open_chk", "1");
	}
	
	public boolean openCheck(String classNo) {
		for(int i = 0; i < str.length; i++) {
			if(str[i][0].equals(classNo) && str[i][4].charAt(0) == '0') {
				return true;	//개설 및 수정 가능
			}
		}
		return false;		//이미 개설함
	}
	
	public boolean deptCheck(String dept) {
		for(Department d : Department.values()) {
			if(d.toString().equals(dept) && !"non".equals(dept)) {
				return true;	//과가 존재
			}
		}
		return false;	//과가 존재하지 않음
	}
}
