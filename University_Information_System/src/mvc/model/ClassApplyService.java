package mvc.model;

import java.util.List;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class ClassApplyService {
	
	private ClassModel classModel;
	private String[][] str;
	private String[] strinfo;
	private DBHelper db;
	private String register = "REGISTER_INFO";
	
	public ClassApplyService() {
		classModel = new ClassModel();
		modelToString();
	}
	
	public void modelToString(){
		int count = 0;
		ClassInfo[] classInfo = classModel.getClassinfo();
		for(int i = 0; i < classInfo.length; i++) {
			if(classInfo[i].getOpenChk()=='1') {
				count++;
			}
		}
		
		if(count == 0) {	//열린 강의가 없다면
			str = new String[1][7];
			strinfo = new String[1];
			str[0][0] = "없음";
			str[0][1] = "없음";
			str[0][2] = "없음";
			str[0][3] = "없음";
			str[0][4] = "없음";
			str[0][5] = "없음";
			str[0][6] = "없음";
			strinfo[0] = "없음";
			return;
		}
		
		str = new String[count][7];
		strinfo = new String[count];
		
		int j = 0;
		for(int i = 0; i < classInfo.length; i++) {
			if(classInfo[i].getOpenChk()=='1') {
				str[j][0] = classInfo[i].getClassNo();
				str[j][1] = classInfo[i].getClassName();
				str[j][2] = classInfo[i].getChargeDept().toString();
				str[j][3] = String.valueOf(classInfo[i].getScore());
				str[j][4] = classInfo[i].getChargeProf();
				str[j][5] = String.valueOf(classInfo[i].getMaxStud());
				str[j][6] = String.valueOf(classInfo[i].getPresentStud());
				strinfo[j] = classInfo[i].getInfo();
				j++;
			}
		}
	}
	
	public int insertClassApply(String studno, String classno) {
		if(checkClass(classno)) {
			if(checkAlready(studno, classno)){
				if(checkScore(studno, classno)) {
					if(checkMax(classno)) {
						db = new DBHelper(register);
						db.insert(classno, studno, "미부여");
						db = new DBHelper("CLASS_INFO");
						db.update("class_no", classno, "present_stud", String.valueOf(getPresent(classno)));
						return 0; //신청 성공
					}
					return 4; //최대 신청 인원을 초과
				}
				return 3; //최대 신청 학점을 초과
			}
			return 2; //이미 해당 강의를 신청함
		}
		return 1;	//강의가 존재하지 않음
	}
	
	public String[][] getStr(){
		return str;
	}
	
	public String[] getStrinfo() {
		return strinfo;
	}
	
	public boolean checkScore(String studno, String classno) {
		int sum = 0;
		db = new DBHelper(register);
		db = new DBHelper("REGISTER_INFO r join CLASS_INFO c using(CLASS_NO)");
		List<String[]> result = db.search("c.score", "stud_no", studno);
		for(int i = 0; i < result.size()-1; i++) {
			String[] rstr = result.get(i+1);
			sum = sum + Integer.parseInt(rstr[0]);
		}
		
		for(int i = 0; i < str.length; i++) {
			if(classno.equals(str[i][0])) {
				sum = sum + Integer.parseInt(str[i][3]);
			}
		}
		
		if(sum > 18) {
			return false;
		}
		return true;
	}
	
	public boolean checkClass(String classno) {
		for(int i = 0; i < str.length; i++) {
			if(str[i][0].equals(classno)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAlready(String studno, String classno) {
		db = new DBHelper(register);
		List<String[]> result = db.search("class_no", "stud_no", studno);
		for(int i = 0; i < result.size()-1; i++) {
			String[] rstr = result.get(i+1);
			if(classno.equals(rstr[0])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkMax(String classno) {
		classModel = new ClassModel();	/* 정확성을 위해 */
		modelToString();				/* 새로고침 하는 부분  */
		
		int i;
		for(i = 0; i < str.length; i++) {
			if(str[i][0].equals(classno)) {
				break;
			}
		}
		
		if(Integer.parseInt(str[i][5]) <= Integer.parseInt(str[i][6])) {	//현재 인원이 최대인원 이상인가?
			return false;
		}
		return true;
	}
	
	public int getPresent(String classno) {
		classModel = new ClassModel();	/* 정확성을 위해 */
		modelToString();			/* 새로고침 하는 부분 */
		
		for(int i = 0; i < str.length; i++) {
			if(str[i][0].equals(classno)) {
				return (Integer.parseInt(str[i][6]) + 1);	//현재인원 추가
			}
		}
		return 0;
	}
	
	
}
