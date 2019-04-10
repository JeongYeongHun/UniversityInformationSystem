package mvc.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JTextField;

/**
 * @author 정영훈
 *
 */

public class ClassApplyPanel extends JPanel implements BasePanel{

	private String id;
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JLabel lblNewLabel;
	private JLabel Text_insert;
	private JTextField InsertNo;
	private JButton btnLogOut;
	private JButton btnUpdate;
	private JButton btnBack;
	private JTable table;
	private JScrollPane scrollPane;
	private String[][] info = {};
	private String[] header = {"과목번호", "과목명", "담당학과", "학점", "담당교수", "최대인원", "현재인원"};
	private JButton btnApply;
	
	public ClassApplyPanel(String id) {
		this.id = id;
		setLayout(null);
		
		setComp();
		setDesign();
	}


	@Override
	public void setComp() {
		Text_PageName = new JLabel("수강신청 화면");
		Text_id = new JLabel(id);
		btnLogOut = new JButton("로그아웃");
		btnUpdate = new JButton("정보변경");
		btnBack = new JButton("<<");
		lblNewLabel = new JLabel("*클릭 시 해당 강의의 설명을 볼 수 있습니다.");
		table = new JTable(info, header);
		Text_insert = new JLabel("신청할 과목번호");
		InsertNo = new JTextField();
		btnApply = new JButton("신청");
		scrollPane = new JScrollPane(table);
	}


	@Override
	public void setDesign() {
		Text_PageName.setBounds(78, 10, 93, 15);
		add(Text_PageName);
		
		Text_id.setBounds(489, 10, 75, 15);
		add(Text_id);
		
		btnLogOut.setBounds(695, 6, 93, 23);
		add(btnLogOut);
		
		btnUpdate.setBounds(577, 6, 98, 23);
		add(btnUpdate);
		
		lblNewLabel.setBounds(12, 49, 278, 15);
		lblNewLabel.setForeground(Color.RED);
		add(lblNewLabel);
		
		scrollPane.setBounds(12, 74, 776, 454);
		add(scrollPane);
		
		btnBack.setBounds(12, 6, 54, 23);
		add(btnBack);
		
		InsertNo.setBounds(559, 557, 116, 21);
		add(InsertNo);
		InsertNo.setColumns(10);
		
		Text_insert.setBounds(438, 560, 119, 15);
		add(Text_insert);
		
		btnApply.setBounds(687, 556, 97, 23);
		add(btnApply);
		
	}
	
	public String getClassNo() {
		return InsertNo.getText();
	}
	
	public String getLogin_id() {
		return Text_id.getText();
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(String[][] info) {
		this.info = info;
		refresh();
	}
	
	public void refresh() {
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 74, 776, 454);
		add(scrollPane);
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JButton getBtnApply() {
		return btnApply;
	}
	
	public int getSelected() {
		return table.getSelectedRow();
	}

	

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
}
