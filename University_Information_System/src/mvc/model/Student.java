package mvc.model;

import main.Department;

/**
 * @author 정영훈
 *
 */

public class Student {
	
	private String num;
	private String password;
	private String name;
	private Department department;
	private String rNum;
	
	public Student(String num, String password, String name,
			Department department, String rNum) {
		this.num = num;
		this.password = password;
		this.name = name;
		this.department = department;
		this.rNum = rNum;
		
	}

	public String getNo() {
		return num;
	}
	
	public String getPw() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Department getDept() {
		return department;
	}
	
	public String getJumin() {
		return rNum;
	}
}
