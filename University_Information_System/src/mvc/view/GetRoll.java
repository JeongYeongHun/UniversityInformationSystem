package mvc.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GetRoll extends ListRoll{
	
	private JLabel Text_PageName;
	
	public GetRoll(String classNo) {
		this.class_num = classNo;
		setLayout(null);
		setHeader();
		setComp();
		Text_PageName = new JLabel("출석부");
		Text_PageName.setBounds(78, 10, 93, 15);
		add(Text_PageName);
		setDesign();
	}
	
	@Override
	public void setHeader() {
		this.header[0] = "학번";
		this.header[1] = "이름";
		this.header[2] = "취득학점";
	}
}
