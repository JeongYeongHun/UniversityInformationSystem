package mvc.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class InsertScore extends JPanel implements BasePanel{

	private String class_num;
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JLabel Text_idinsert;
	private JLabel Text_scoreinsert;
	private JButton btnLogOut;
	private JButton btnBack;
	private JButton btnInsert;
	private JTextField id;
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnC;
	private JRadioButton rdbtnD;
	private JRadioButton rdbtnF;
	private ButtonGroup group;
	
	private String[][] info = {};
	private String[] header = {"학번", "이름", "취득학점"};
	
	public InsertScore(String class_num) {
		this.class_num = class_num;
		setLayout(null);
		
		setComp();
		setDesign();
	}


	@Override
	public void setComp() {
		Text_PageName = new JLabel("성적 입력");
		Text_id = new JLabel(class_num);
		Text_idinsert = new JLabel("학번");
		Text_scoreinsert = new JLabel("성적");
		btnLogOut = new JButton("로그아웃");
		btnBack = new JButton("<<");
		btnInsert = new JButton("입력");
		id = new JTextField();
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
		rdbtnA = new JRadioButton("A");
		rdbtnB = new JRadioButton("B");
		rdbtnC = new JRadioButton("C");
		rdbtnD = new JRadioButton("D");
		rdbtnF = new JRadioButton("F");
		group = new ButtonGroup();
	}


	@Override
	public void setDesign() {
		Text_PageName.setBounds(78, 10, 93, 15);
		add(Text_PageName);
		
		Text_id.setBounds(328, 10, 75, 15);
		add(Text_id);
		
		btnLogOut.setBounds(438, 6, 93, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 74, 534, 454);
		add(scrollPane);
		
		btnBack.setBounds(12, 6, 54, 23);
		add(btnBack);
		
		
		btnInsert.setBounds(434, 596, 97, 23);
		add(btnInsert);
		
		Text_idinsert.setBounds(33, 565, 116, 21);
		add(Text_idinsert);
		
		id.setBounds(33, 597, 116, 21);
		add(id);
		
		Text_scoreinsert.setBounds(198, 565, 116, 21);
		add(Text_scoreinsert);
		
		rdbtnA.setBounds(198, 596, 38, 23);
		group.add(rdbtnA);
		add(rdbtnA);
		
		rdbtnB.setBounds(238, 596, 38, 23);
		group.add(rdbtnB);
		add(rdbtnB);
		
		rdbtnC.setBounds(276, 596, 38, 23);
		group.add(rdbtnC);
		add(rdbtnC);
		
		rdbtnD.setBounds(319, 596, 38, 23);
		group.add(rdbtnD);
		add(rdbtnD);
		
		rdbtnF.setBounds(361, 596, 38, 23);
		group.add(rdbtnF);
		add(rdbtnF);
		
		
		
	}
	
	
	public String getclass_num() {
		return Text_id.getText();
	}
	
	public String getIdInsert() {
		return id.getText();
	}

	
	public JTable getTable() {
		return table;
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	
	public JButton getBtnInsert() {
		return btnInsert;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public int getSelected() {
		return table.getSelectedRow();
	}
	
	
	
	public JRadioButton getRdbtnA() {
		return rdbtnA;
	}

	public JRadioButton getRdbtnB() {
		return rdbtnB;
	}

	public JRadioButton getRdbtnC() {
		return rdbtnC;
	}

	public JRadioButton getRdbtnD() {
		return rdbtnD;
	}

	public JRadioButton getRdbtnF() {
		return rdbtnF;
	}

	public void setTable(String[][] info) {
		this.info = info;
		refresh();
	}
	
	public void refresh() {
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 74, 534, 454);
		add(scrollPane);
	}
	
	
	

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
