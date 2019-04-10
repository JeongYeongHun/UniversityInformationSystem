package mvc.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ProfessorPanel extends JPanel implements BasePanel {
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JLabel insert_class;
	private JButton btnLogOut;
	private JButton btnList;
	private JButton btnRoll;
	private JButton btnScore;
	private JButton btnUpdate;
	private JTextField classnum;
	private JTable table;
	private JScrollPane scrollPane;
	private String[][] info = {};
	private String[] header = {"과목번호", "과목명", "담당학과", "학점", "담당교수",};
	private String id;
	
	public ProfessorPanel(String id) {
		this.id = id;
		setLayout(null);
		
		setComp();
		setDesign();
	}


	@Override
	public void setComp() {
		Text_PageName = new JLabel("교수 화면");
		Text_id = new JLabel(id);
		insert_class = new JLabel("과목번호 입력");
		classnum = new JTextField();
		btnLogOut = new JButton("로그아웃");
		btnUpdate = new JButton("정보변경");
		btnList = new JButton("명단부 확인");
		btnRoll = new JButton("출석부 확인");
		btnScore = new JButton("성적 입력");
		
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
		
	}


	@Override
	public void setDesign() {
		Text_PageName.setBounds(12, 10, 57, 15);
		add(Text_PageName);
		
		Text_id.setBounds(133, 10, 57, 15);
		add(Text_id);
		
		btnLogOut.setBounds(335, 6, 93, 23);
		add(btnLogOut);
		
		
		btnRoll.setBounds(24, 351, 121, 73);
		add(btnRoll);
		
		insert_class.setBounds(24, 301, 97, 23);
		add(insert_class);
		
		classnum.setBounds(24, 321, 97, 23);
		add(classnum);
		
		
		btnList.setBounds(168, 351, 121, 73);
		add(btnList);
		
		
		btnScore.setBounds(307, 351, 121, 73);
		add(btnScore);
		
		
		btnUpdate.setBounds(230, 6, 93, 23);
		add(btnUpdate);
		
		
		scrollPane.setBounds(12, 62, 416, 150);
		add(scrollPane);
	}
	public String getclass_num() {
		return classnum.getText();
	}
	
	public String getLogin_id() {
		return Text_id.getText();
	}
	
	public void setTable(String[][] info) {
		this.info = info;
		refresh();
	}
	
	public void refresh() {
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 62, 416, 150);
		add(scrollPane);
	}	

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}


	public JButton getBtnList() {
		return btnList;
	}


	public JButton getBtnRoll() {
		return btnRoll;
	}


	public JButton getBtnScore() {
		return btnScore;
	}



	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	
	
	
}
