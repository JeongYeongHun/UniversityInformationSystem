package mvc.model;

import main.Department;

public class ListRollInfo {
	private String no;
	private String name;
	private String password;
	private Department chargeDept;
	private String rNumber;
	private String classNo;
	private String studNo;
	private String score;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getChargeDept() {
		return chargeDept;
	}

	public void setChargeDept(Department chargeDept) {
		this.chargeDept = chargeDept;
	}

	public String getRNumber() {
		return rNumber;
	}

	public void setRNumber(String rNumber) {
		this.rNumber = rNumber;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getStudNo() {
		return studNo;
	}

	public void setStudNo(String studNo) {
		this.studNo = studNo;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
