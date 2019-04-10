package mvc.model;

import java.util.List;

import main.DBHelper;

/**
 * @author 정영훈
 *
 */

public class LoginService {
	private String id;
	private String password;
	private String idType;
	
	public LoginService(String id, String password) {
		this.id = id;
		this.password = password;
		this.idType = idType();
	}
	
	public boolean login() {
		if(idType == null) {	//로그인 가능 유형의 아이디가 아닌경우
			return false;
		}
		else {
			DBHelper db = new DBHelper(idType);
			List<String[]> result;
			result = db.search("password", "no", id);
			if(result.size() == 2) {	//id가 존재하는 경우는 result.size()가 2, 존재하지 않는경우면 1
				String[] record = result.get(1);	//0번째에 저장된건 칼럼명이기 때문에
				if(record[0].equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void logout() {
		//구현예정
	}
	
	public String idType() {
		String strtype = id.substring(0, 1);
		switch(strtype.charAt(0)) {
			case 'S':
				return "STUDENT_INFO";
			case 'P':
				return "PROFESSOR_INFO";
			case 'H':
				return "DEPT_MANAGER_INFO";
			case 'G':
				return "CLASS_MANAGER_INFO";
			case 'M':
				return "MASTER";
			default:
				return null;	
		}
	}

	public String getIdType() {
		return idType;
	}
}
