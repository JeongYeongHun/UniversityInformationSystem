package mvc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class DeptManagerAddDialog extends JDialog implements BasePanel {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPaneDMAD;
	private JButton okButtonDMAD;
	private JButton cancelButtonDMAD;
	private JLabel TextidDMAD;
	private JTextField idDMAD;
	private JLabel TextnameDMAD;
	private JTextField nameDMAD;
	private JLabel TextdeptDMAD;
	private JTextField deptDMAD;
	private JLabel TextjuminDMAD;
	private JTextField juminDMAD;

	public DeptManagerAddDialog() {
		setBounds(100, 100, 242, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		buttonPaneDMAD = new JPanel();
		okButtonDMAD = new JButton("OK");
		cancelButtonDMAD = new JButton("Cancel");
		TextidDMAD = new JLabel("아이디");
		TextidDMAD.setBounds(12, 10, 73, 15);
		idDMAD = new JTextField();
		idDMAD.setBounds(97, 6, 116, 21);
		TextnameDMAD = new JLabel("이름");
		TextnameDMAD.setBounds(12, 43, 73, 15);
		nameDMAD = new JTextField();
		nameDMAD.setBounds(97, 39, 116, 21);
		TextdeptDMAD = new JLabel("학과");
		TextdeptDMAD.setBounds(12, 82, 73, 15);
		deptDMAD = new JTextField();
		deptDMAD.setBounds(97, 78, 116, 21);
		TextjuminDMAD = new JLabel("주민번호");
		TextjuminDMAD.setBounds(12, 115, 73, 15);
		juminDMAD = new JTextField();
		juminDMAD.setBounds(97, 111, 116, 21);
	}
	
	@Override
	public void setDesign() {
		buttonPaneDMAD.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPaneDMAD, BorderLayout.SOUTH);
		
		okButtonDMAD.setActionCommand("OK");
		buttonPaneDMAD.add(okButtonDMAD);
		getRootPane().setDefaultButton(okButtonDMAD);
		
		cancelButtonDMAD.setActionCommand("Cancel");
		buttonPaneDMAD.add(cancelButtonDMAD);
		contentPanel.setLayout(null);
		contentPanel.add(TextidDMAD);
		contentPanel.add(idDMAD);
		idDMAD.setColumns(10);
		contentPanel.add(TextnameDMAD);
		contentPanel.add(nameDMAD);
		nameDMAD.setColumns(10);
		contentPanel.add(TextdeptDMAD);
		contentPanel.add(deptDMAD);
		deptDMAD.setColumns(10);
		contentPanel.add(TextjuminDMAD);
		contentPanel.add(juminDMAD);
		juminDMAD.setColumns(10);
	}

	public JButton getOkButton() {
		return okButtonDMAD;
	}

	public JButton getCancelButton() {
		return cancelButtonDMAD;
	}

	public String getId() {
		return idDMAD.getText();
	}

	@Override
	public String getName() {
		return nameDMAD.getText();
	}
	
	public String getDept() {
		return deptDMAD.getText();
	}
	
	public String getJumin() {
		return juminDMAD.getText();
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
