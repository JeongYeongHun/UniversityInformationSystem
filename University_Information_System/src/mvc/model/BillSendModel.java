package mvc.model;

import java.util.List;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class BillSendModel {
	
	private DBHelper db;
	private String[][] arr;
	
	public BillSendModel() {
		db = new DBHelper("REGISTER_INFO");
		
		listToString();
	}
	
	public void listToString() {
		List<String[]> list = db.search("distinct stud_no", "stud_no!", "master");
		
		if(list.size() != 1) {	//값이 존재한다면
			arr = new String[list.size()-1][1];
			
			for(int i = 0; i < list.size()-1; i++) {
				String[] result = list.get(i+1);
				arr[i][0] = result[0];
			}
		}
		else {
			arr = new String[1][1];
			arr[0][0] = "없음";
		}
	}
	
	public boolean checkStud(String no) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0].equals(no)) {
				return true;	//값이 존재
			}
		}
		return false;	//값이 존재하지 않음
	}
	
	public String[][] getInfo(){
		return arr;
	}
	
}
