package mvc.model;

import main.Department;

/**
 * @author 정영훈
 *
 */

public class ClassInfo {
	private String classNo;
	private String className;
	private Department chargeDept;
	private int score;
	private String info = null;
	private char openChk = '0';
	private String chargeProf = null;
	private int minStud = 0;
	private int maxStud = 0;
	private int presentStud = 0;
	
	public ClassInfo(String classNo, String className, Department chargeDept, int score) {
		this.classNo = classNo;
		this.className = className;
		this.chargeDept = chargeDept;
		this.score = score;
	}

	//update 대신 setter
	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		if(openChk=='0')
			this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		if(openChk=='0')
			this.className = className;
	}

	public Department getChargeDept() {
		return chargeDept;
	}

	public void setChargeDept(Department chargeDept) {
		if(openChk=='0')
			this.chargeDept = chargeDept;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if(openChk=='0')
			this.score = score;
	}

	public void setOpenChk(char openChk) {
		this.openChk = openChk;
	}

	public String getChargeProf() {
		return chargeProf;
	}

	public void setChargeProf(String chargeProf) {
		this.chargeProf = chargeProf;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public char getOpenChk() {
		return openChk;
	}

	public int getMinStud() {
		return minStud;
	}
	
	public void setMinStud(int minStud) {
		this.minStud = minStud;
	}

	public int getMaxStud() {
		return maxStud;
	}

	public void setMaxStud(int maxStud) {
		this.maxStud = maxStud;
	}

	public int getPresentStud() {
		return presentStud;
	}

	public void setPresentStud(int presentStud) {
		this.presentStud = presentStud;
	}
}
