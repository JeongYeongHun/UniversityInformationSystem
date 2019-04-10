package mvc.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author 정영훈
 *
 */

public class CheckScorePanel extends JPanel implements BasePanel{
	private String id;
	private JButton btnBack;
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JButton btnUpdate;
	private JButton btnLogOut;
	private JTable table;
	private JScrollPane scrollPane;
	private String[][] info = {};
	private String[] header = {"과목번호", "과목명", "담당학과", "학점", "담당교수", "성적"};
	
	public CheckScorePanel(String id) {
		this.id = id;
		setLayout(null);
		
		setComp();
		setDesign();
		
	}

	@Override
	public void setComp() {
		btnBack = new JButton("<<");
		Text_PageName = new JLabel("성적 조회 화면");
		Text_id = new JLabel(id);
		btnUpdate = new JButton("정보변경");
		btnLogOut = new JButton("로그아웃");
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
	}

	@Override
	public void setDesign() {
		btnBack.setBounds(12, 10, 54, 23);
		add(btnBack);
		
		Text_PageName.setBounds(78, 14, 98, 15);
		add(Text_PageName);
		
		Text_id.setBounds(489, 14, 75, 15);
		add(Text_id);
		
		btnUpdate.setBounds(577, 10, 98, 23);
		add(btnUpdate);
		
		btnLogOut.setBounds(695, 10, 93, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 74, 776, 454);
		add(scrollPane);
	}

	public String getLogin_id() {
		return Text_id.getText();
	}
	
	public JButton getBtnBack() {
		return btnBack;
	}


	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public void setInfo(String[][] info) {
		this.info = info;
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(12, 74, 776, 454);
		add(scrollPane);
	}

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
