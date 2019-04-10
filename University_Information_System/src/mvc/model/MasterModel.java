package mvc.model;

/**
 * @author 정영훈
 *
 */

public class MasterModel {
	private MDeptManagerModel deptManagerModel;
	private MClassManagerModel classManagerModel;
	private String[][] sum;
	
	public MasterModel() {
		deptManagerModel = new MDeptManagerModel();
		classManagerModel = new MClassManagerModel();
		sum = getInfo();
	}
	
	public String[][] getInfo(){
		String[][] str = deptManagerModelToString();
		String[][] str2 = classManagerModelToString();
		sum = new String[str.length + str2.length][4];
		for(int i = 0; i < str.length; i++) {
			sum[i] = str[i];
		}
		for(int i = str.length; i < (str.length + str2.length); i++) {
			sum[i] = str2[i-str.length];
		}
		return sum;
	}
	
	public String[][] deptManagerModelToString() {
		Employee[] dManager = deptManagerModel.getInfo();
		String[][] str = new String[dManager.length][4];
		for(int i = 0; i < dManager.length; i++) {
			str[i][0] = dManager[i].getName();
			str[i][1] = dManager[i].getNo();
			str[i][2] = dManager[i].getPw();
			str[i][3] = dManager[i].getRnum();
		}
		return str;
	}
	
	public String[][] classManagerModelToString() {
		Employee[] cManager = classManagerModel.getInfo();
		String[][] str = new String[cManager.length][4];
		for(int i = 0; i < cManager.length; i++) {
			str[i][0] = cManager[i].getName();
			str[i][1] = cManager[i].getNo();
			str[i][2] = cManager[i].getPw();
			str[i][3] = cManager[i].getRnum();
		}
		return str;
	}
	
	public boolean compareSpace(String id, String pw, String name) {
		if("".equals(id) || "".equals(pw) || "".equals(name)) {
			return false;
		}
		return true;
	}
	
	public boolean compareDmanager(String id) {
		if(id.charAt(0) == 'H') {
			return true;
		}
		return false;
	}
	
	public boolean compareCmanager(String id) {
		if(id.charAt(0) == 'G') {
			return true;
		}
		return false;
	}
	
	public boolean checkID(String id) {
		for(int i = 0; i < sum.length; i++) {
			if(sum[i][1].equals(id)) {
				return false;	//아이디 존재
			}
		}
		return true;	//아이디가 존재하지 않음
	}
	
	public void insertClassManager(String name, String no, String rnum) {
		classManagerModel.insertInfo(name, no, rnum);
	}
	
	public void insertDeptManager(String name, String no, String rnum) {
		deptManagerModel.insertInfo(name, no, rnum);
	}
	
	public void deleteClassManager(String column, String value) {
		classManagerModel.deleteInfo(column, value);
	}
	
	public void deleteDeptManager(String column, String value) {
		deptManagerModel.deleteInfo(column, value);
	}
	
	public void updateClassManager(String name, String no, String rnum) {
		classManagerModel.update(name, no, rnum);
	}
	
	public void updateDeptManager(String name, String no, String rnum) {
		deptManagerModel.update(name, no, rnum);
	}
	
}
