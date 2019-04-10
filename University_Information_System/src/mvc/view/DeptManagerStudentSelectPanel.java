package mvc.view;

public class DeptManagerStudentSelectPanel extends DeptManagerSelectPanel {
	
	public DeptManagerStudentSelectPanel(String id) {
		this.id = id;
		setLayout(null);
		
		setHeader();
		
		setComp();
		setTextNo("학번");
		
		setDesign();
	}

	@Override
	public void setHeader() {
		this.header[0] = "학번";
		this.header[1] = "이름";
		this.header[2] = "비밀번호";
		this.header[3] = "학과";
		this.header[4] = "주민번호";
	}
}
