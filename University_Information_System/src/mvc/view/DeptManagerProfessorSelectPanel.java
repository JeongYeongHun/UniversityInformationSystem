package mvc.view;

public class DeptManagerProfessorSelectPanel extends DeptManagerSelectPanel {
	
	public DeptManagerProfessorSelectPanel(String id) {
		this.id = id;
		setLayout(null);
		setHeader();
		
		setComp();
		super.setTextNo("교수번호");
		
		setDesign();
	}

	@Override
	public void setHeader() {
		this.header[0] = "교수번호";
		this.header[1] = "이름";
		this.header[2] = "비밀번호";
		this.header[3] = "학과";
		this.header[4] = "주민번호";
	}
}
