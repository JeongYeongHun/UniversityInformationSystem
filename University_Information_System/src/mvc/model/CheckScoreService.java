package mvc.model;

import java.util.List;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class CheckScoreService {
	
	private DBHelper db;
	
	public CheckScoreService() {
		db = new DBHelper("REGISTER_INFO r join CLASS_INFO c using(CLASS_NO)");
	}
	
	
	public String[][] getScoreInfo(String studno) {
		List<String[]> result = db.search("class_no, c.class_name, c.charge_dept, c.score, c.charge_prof, r.score as sco", "stud_no", studno);
		String[][] scoreInfo;
		if(result.size() < 2) {
			scoreInfo = new String[1][6];
			return scoreInfo;
		}
		scoreInfo = new String[result.size()-1][6];
		for(int i = 0; i < result.size()-1; i++) {
			String[] record = result.get(i+1);
			scoreInfo[i][0] = record[0];
			scoreInfo[i][1] = record[1];
			scoreInfo[i][2] = record[2];
			scoreInfo[i][3] = record[3];
			scoreInfo[i][4] = record[4];
			scoreInfo[i][5] = record[5];
		}
		return scoreInfo;
	}
	
}
