package mvc.model;

/**
 * @author 정영훈
 *
 */

public class Employee {
	private String name;
	private String no;
	private String pw;
	private String rnum;
	
	public Employee(String name, String no, String pw, String rnum) {
		this.name = name;
		this.no = no;
		this.pw = pw;
		this.rnum = rnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	
}
