package mvc.model;

import java.util.List;

import main.DBHelper;
import main.Department;

/**
 * @author 정영훈
 *
 */

public class ClassModel {
	private ClassInfo[] classinfo;
	private DBHelper db;
	private List<String[]> arr;
	
	public ClassModel() {
		db = new DBHelper("CLASS_INFO");
		arr = db.selectAll();
		matching();
	}
	
	public void matching() {
		if((arr.size()-1) > 0) {
			classinfo = new ClassInfo[arr.size()-1];
			for(int i = 0; i < (arr.size()-1); i++) {
				String[] record = arr.get(i+1);
				classinfo[i] = new ClassInfo(record[0], record[1], Department.valueOf(record[2]), Integer.parseInt(record[3]));
				classinfo[i].setInfo(record[4]);
				classinfo[i].setOpenChk(record[5].charAt(0));
				classinfo[i].setChargeProf(record[6]);
				classinfo[i].setMinStud(Integer.parseInt(record[7]));
				classinfo[i].setMaxStud(Integer.parseInt(record[8]));
				classinfo[i].setPresentStud(Integer.parseInt(record[9]));
			}
		}
		else {
			classinfo = new ClassInfo[1];
			classinfo[0] = new ClassInfo("없음", "없음", Department.valueOf("전산학과"), 0);
			classinfo[0].setInfo("없음");
			classinfo[0].setOpenChk('1');
			classinfo[0].setChargeProf("없음");
			classinfo[0].setMinStud(0);
			classinfo[0].setMaxStud(0);
			classinfo[0].setPresentStud(0);
		}
	}
	
	public ClassInfo[] getClassinfo() {
		return classinfo;
	}
	
	public boolean compareSpace(String classNo, String className, String chargeDept, String score) {
		if("".equals(classNo) || "".equals(className) || "".equals(chargeDept) || "".equals(score)) {
			return false;
		}
		return true;
	}
}
