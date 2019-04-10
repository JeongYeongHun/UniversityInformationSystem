package mvc.view;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.SwingConstants;

public class ClassManagerPanel extends JPanel implements BasePanel {

	private String id;
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JLabel lblNewLabel;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLogOut;
	private JButton btnModify;
	private JTable table;
	private JScrollPane scrollPane;
	private String[][] info = {};
	private String[] header = {"강좌 번호", "강좌 이름", "담당 학과", "학점 수", "개설여부", "담당 교수", "최소 학생수", "최대 학생수", "현재 학생수"};
	private JButton btnOpen;
	private JButton btnbillSend;
	
	public ClassManagerPanel(String id) {
		this.id = id;
		setLayout(null);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		Text_PageName = new JLabel("수업담당자 화면");
		lblNewLabel = new JLabel("*클릭 시 해당 강의의 설명을 볼 수 있습니다.");
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
		Text_id = new JLabel(id);
		btnAdd = new JButton("강좌등록");
		btnModify = new JButton("정보변경");
		btnUpdate = new JButton("강좌수정");
		btnDelete = new JButton("강좌삭제");
		btnLogOut = new JButton("로그아웃");
		btnOpen = new JButton("강의개설");
		btnbillSend = new JButton("수강료 청구서 발급        >>");
	}

	@Override
	public void setDesign() {
		Text_PageName.setBounds(12, 14, 98, 15);
		add(Text_PageName);
		
		Text_id.setBounds(427, 14, 75, 15);
		add(Text_id);
		
		lblNewLabel.setBounds(12, 47, 278, 15);
		lblNewLabel.setForeground(Color.RED);
		add(lblNewLabel);
		
		btnUpdate.setBounds(139, 573, 98, 23);
		add(btnUpdate);
		
		btnModify.setBounds(563, 10, 97, 23);
		add(btnModify);
		
		btnAdd.setBounds(12, 573, 98, 23);
		add(btnAdd);
		
		btnDelete.setBounds(266, 573, 98, 23);
		add(btnDelete);
		
		btnLogOut.setBounds(691, 10, 93, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 74, 776, 485);
		add(scrollPane);
		
		btnOpen.setBounds(691, 573, 97, 23);
		add(btnOpen);
		
		btnbillSend.setHorizontalAlignment(SwingConstants.RIGHT);
		btnbillSend.setBounds(563, 43, 221, 23);
		add(btnbillSend);
	}

	public String getLogin_id() {
		return Text_id.getText();
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
	public JButton getBtnDelete() {
		return btnDelete;
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
	
	public JButton getBtnModify() {
		return btnModify;
	}
	
	public JButton getBtnOpen() {
		return btnOpen;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public int getSelected() {
		return table.getSelectedRow();
	}

	public JButton getBillSend() {
		return btnbillSend;
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}

