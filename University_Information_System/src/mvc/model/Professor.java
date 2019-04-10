package mvc.model;

import main.Department;

public class Professor {

	private String no;
	private String name;
	private String pw;
	private Department dept;
	private String jumin;
	
	public Professor(String no, String name, String pw,
		Department dept, String jumin) {
		this.no = no;
		this.name = name;
		this.pw = pw;
		this.dept = dept;
		this.jumin = jumin;
		
	}

	public String getNo() {
		return no;
	}
	
	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public Department getDept() {
		return dept;
	}
	
	public String getJumin() {
		return jumin;
	}
}
