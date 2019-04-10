package mvc.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author 정영훈
 *
 */

public abstract class DeptManagerSelectPanel extends JPanel implements BasePanel{
	public DeptManagerSelectPanel() {
	}

	protected String id;
	protected JButton btnBack;
	protected JLabel Text_PageName;
	protected JLabel Text_id;
	protected JButton btnAdd;
	protected JButton btnUpdate;
	protected JButton btnDelete;
	protected JButton btnLogOut;
	protected JTable table;
	protected JScrollPane scrollPane;
	protected String[][] info = {};
	protected String[] header = {"", "", "", "", ""};
	protected JLabel Text_name;
	protected JLabel Text_no;
	protected JTextField nameSearch;
	protected JButton btnSearch;
	protected JTextField noSearch;
	protected JButton btnModify;
	protected JRadioButton btnNoRadio;
	protected JRadioButton btnNameRadio;
	protected ButtonGroup bg;
	
	public void setComp(){
		btnBack = new JButton("<<");
		Text_PageName = new JLabel("정보 조회 화면");
		Text_id = new JLabel(id);
		btnAdd = new JButton("등록");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		btnLogOut = new JButton("로그아웃");
		Text_no = new JLabel("번호");
		Text_name = new JLabel("이름");
		nameSearch = new JTextField();
		noSearch = new JTextField();
		btnSearch = new JButton("검색");
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
		btnModify = new JButton("정보변경");
		btnNoRadio = new JRadioButton("");
		btnNameRadio = new JRadioButton("");
		bg = new ButtonGroup();
	}
	
	public void setDesign() {
		btnNoRadio.setBounds(340, 540, 37, 15);
		
		btnNameRadio.setBounds(512, 540, 37, 15);
		
		bg.add(btnNoRadio);
		bg.add(btnNameRadio);
		
		add(btnNoRadio);
		add(btnNameRadio);
		
		btnNoRadio.setSelected(true);
		
		Text_PageName.setBounds(78, 14, 98, 15);
		add(Text_PageName);
		
		Text_id.setBounds(273, 14, 75, 15);
		add(Text_id);
		
		Text_name.setBounds(512, 561, 37, 15);
		add(Text_name);
		
		Text_no.setBounds(325, 561, 65, 15);
		add(Text_no);
		
		btnAdd.setBounds(362, 10, 98, 23);
		add(btnAdd);
		
		btnBack.setBounds(12, 10, 54, 23);
		add(btnBack);
		
		btnUpdate.setBounds(474, 10, 98, 23);
		add(btnUpdate);
		
		btnDelete.setBounds(586, 10, 98, 23);
		add(btnDelete);
		
		btnModify.setBounds(695, 40, 93, 23);
		add(btnModify);
		
		btnLogOut.setBounds(695, 10, 93, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 74, 776, 454);
		add(scrollPane);
		
		nameSearch.setBounds(557, 557, 116, 21);
		add(nameSearch);
		nameSearch.setColumns(10);
		
		btnSearch.setBounds(687, 556, 97, 23);
		add(btnSearch);
		
		noSearch.setBounds(382, 557, 116, 21);
		add(noSearch);
		noSearch.setColumns(10);
		
		
	}

	@Override
	public void msgPrint(String str) {
		// 구현 미필요
	}
	
	public String getLogin_id() {
		return Text_id.getText();
	}
	
	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public JButton getBtnModify() {
		return btnModify;
	}
	
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setTextNo(String str) {
		Text_no.setText(str);
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(String[][] info) {
		this.info = info;
		refresh();
	}
	
	public String getNoSearch() {
		return noSearch.getText();
	}
	
	public String getNameSearch() {
		return nameSearch.getText();
	}
	
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
	public JButton getBtnSearch() {
		return btnSearch;
	}
	
	public JRadioButton getBtnNoRadio() {
		return btnNoRadio;
	}
	
	public JRadioButton getBtnNameRadio() {
		return btnNameRadio;
	}

	public void setInfo(String[][] info) {
		this.info = null;
		this.info = info;
		refresh();
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public void refresh() {
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 74, 776, 454);
		add(scrollPane);
	}
	
	public abstract void setHeader();
	

}
