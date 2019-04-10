package mvc.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GetList extends ListRoll{
	
	private JLabel Text_PageName;
	
	public GetList(String classNum) {
		this.class_num = classNum;
		setLayout(null);
		
		setHeader();
		
		setComp();
		Text_PageName = new JLabel("명단부");

		setDesign();
		Text_PageName.setBounds(78, 10, 93, 15);
		add(Text_PageName);
	}

	@Override
	public void setHeader() {
		this.header[0] = "학번";
		this.header[1] = "이름";
		this.header[2] = "학과";
	}
}
