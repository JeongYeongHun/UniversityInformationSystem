package mvc.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author 정영훈
 *
 */

public abstract class ListRoll extends JPanel implements BasePanel {

	protected String class_num;
	protected JLabel Text_id;
	protected JButton btnLogOut;
	protected JButton btnBack;
	protected JTable table;
	protected JScrollPane scrollPane;
	protected String[][] info = {};
	protected String[] header = {"", "", ""};
	

	@Override
	public void setComp() {
		Text_id = new JLabel(class_num);
		btnLogOut = new JButton("로그아웃");
		btnBack = new JButton("<<");
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
	}


	@Override
	public void setDesign() {
		Text_id.setBounds(328, 10, 75, 15);
		add(Text_id);
		
		btnLogOut.setBounds(438, 6, 93, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 74, 534, 454);
		add(scrollPane);
		
		btnBack.setBounds(12, 6, 54, 23);
		add(btnBack);
		
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	public String getLogin_id() {
		return Text_id.getText();
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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public int getSelected() {
		return table.getSelectedRow();
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
	
	public abstract void setHeader();
}
