package mvc.model;

import java.util.List;

import main.DBHelper;
import main.Department;

public class ProClassModel {
	private ClassInfo[] proclassinfo;
	private DBHelper db;
	private List<String[]> arr;
	private String proName;
	
	public ProClassModel(String id) {
		proName = profName(id);
		db = new DBHelper("CLASS_INFO");
		arr = db.search("*", "charge_prof", proName);
		matching();
	}
	
	public void matching() {
		if((arr.size()-1) > 0) {
			proclassinfo = new ClassInfo[arr.size()-1];
			for(int i = 0; i < (arr.size()-1); i++) {
				String[] record = arr.get(i+1);
				proclassinfo[i] = new ClassInfo(record[0],record[1],Department.valueOf(record[2]),Integer.parseInt(record[3]));
				proclassinfo[i].setChargeProf(record[6]);
				proclassinfo[i].setInfo(record[4]);
				proclassinfo[i].setOpenChk(record[5].charAt(0));
				proclassinfo[i].setMinStud(Integer.parseInt(record[7]));
				proclassinfo[i].setMaxStud(Integer.parseInt(record[8]));
				proclassinfo[i].setPresentStud(Integer.parseInt(record[9]));
			}
		}
		else {
			proclassinfo = new ClassInfo[1];
			proclassinfo[0] = new ClassInfo("없음", "없음", Department.valueOf("전산학과"), 0);
			proclassinfo[0].setChargeProf("없음");
			proclassinfo[0].setInfo("없음");
			proclassinfo[0].setOpenChk('0');
			proclassinfo[0].setMinStud(0);
			proclassinfo[0].setMaxStud(0);
			proclassinfo[0].setPresentStud(0);
		}
		
		
	}

	public ClassInfo[] getProclassinfo() {
		return proclassinfo;
	}

	public String profName(String id) {
		db = new DBHelper("PROFESSOR_INFO");
		List<String[]> name = db.search("name", "no", id);
		String[] record = name.get(1);
		return record[0];
	}

}