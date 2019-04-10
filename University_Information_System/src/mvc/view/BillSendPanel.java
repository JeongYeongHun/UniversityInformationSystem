package mvc.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author 정영훈
 *
 */

public class BillSendPanel extends JPanel implements BasePanel{
	
	private String id;
	private JButton btnBack;
	private JLabel Text_PageName;
	private JLabel TextId;
	private JButton btnBill;
	private JButton btnLogOut;
	private JTable table;
	private JScrollPane scrollPane;
	private String[][] info = {};
	private String[] header = {"학번"};
	private JTextField studNo;
	private JLabel lblNewLabel;
	
	public BillSendPanel() {

		setComp();
		setDesign();
	}

	@Override
	public void setComp() {
		studNo = new JTextField();
		lblNewLabel = new JLabel("학번");
		Text_PageName = new JLabel("수강 신청 학생 목록");
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);
		TextId = new JLabel(id);
		btnBill = new JButton("청구서 발급");
		btnLogOut = new JButton("로그아웃");
	}

	@Override
	public void setDesign() {
		setLayout(null);
		btnBack = new JButton("<<");
		
		btnBack.setBounds(12, 5, 49, 23);
		add(btnBack);
		Text_PageName.setBounds(109, 9, 132, 15);
		add(Text_PageName);
		
		TextId.setBounds(222, 16, 0, 0);
		add(TextId);
		
		btnBill.setBounds(312, 264, 115, 23);
		add(btnBill);

		btnLogOut.setBounds(329, 5, 98, 23);
		add(btnLogOut);
		
		scrollPane.setBounds(12, 33, 415, 221);
		add(scrollPane);
		
		
		studNo.setBounds(184, 265, 116, 21);
		add(studNo);
		studNo.setColumns(10);
		
		lblNewLabel.setBounds(133, 268, 57, 15);
		add(lblNewLabel);

	}

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	public void setTable(String[][] info) {
		this.info = info;
		refresh();
	}
	
	public void refresh() {
		remove(scrollPane);
		table = new JTable(info, header);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 33, 415, 221);
		add(scrollPane);
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	
	public String getStudNo() {
		return studNo.getText();
	}

	public JButton getBtnBill() {
		return btnBill;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	
}
