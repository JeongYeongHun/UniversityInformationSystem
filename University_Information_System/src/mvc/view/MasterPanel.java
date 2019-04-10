package mvc.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

/**
 * @author 정영훈
 *
 */

public class MasterPanel extends JPanel implements BasePanel{

	private JLabel textPageName;
	private JButton btnLogOut;
	private String[][] info = {};
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnModify;
	private String[] header = {"이름", "직원번호", "비밀번호", "주민번호"};
	private JButton btnUpdate;
	
	public MasterPanel() {
		setLayout(null);
		
		setComp();
		setDesign();
	}

	@Override
	public void setComp() {
		textPageName = new JLabel("관리자 화면");
		btnLogOut = new JButton("로그아웃");
		btnUpdate = new JButton("정보변경");
		btnInsert = new JButton("추가");
		btnDelete = new JButton("삭제");
		btnModify = new JButton("수정");
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
	}

	@Override
	public void setDesign() {
		textPageName.setBounds(12, 10, 104, 15);
		add(textPageName);
		
		btnLogOut.setBounds(345, 10, 93, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 43, 426, 214);
		add(scrollPane);
		
		btnInsert.setBounds(19, 267, 97, 23);
		add(btnInsert);
		
		btnDelete.setBounds(341, 267, 97, 23);
		add(btnDelete);
		
		btnModify.setBounds(180, 267, 97, 23);
		add(btnModify);
		
		btnUpdate.setBounds(240, 10, 93, 23);
		add(btnUpdate);
	}

	public void setInfo(String[][] info) {
		this.info = info;
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 43, 426, 214);
		add(scrollPane);
	}

	
	
	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnInsert() {
		return btnInsert;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}


	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
