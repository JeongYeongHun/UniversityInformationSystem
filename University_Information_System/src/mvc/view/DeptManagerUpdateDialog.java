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

public class DeptManagerUpdateDialog extends JDialog implements BasePanel {
	
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel Textid;
	private JTextField id;
	private JLabel Textname;
	private JTextField name;
	private JLabel Textdept;
	private JTextField dept;
	private JLabel Textjumin;
	private JTextField jumin;

	public DeptManagerUpdateDialog() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setBounds(100, 100, 276, 243);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		buttonPane = new JPanel();
		Textid = new JLabel("기존 아이디");
		id = new JTextField();
		Textname = new JLabel("변경할 이름");
		name = new JTextField();
		Textdept = new JLabel("변경할 학과");
		dept = new JTextField();
		Textjumin = new JLabel("변경할 주민번호");
		jumin = new JTextField();
		cancelButton = new JButton("Cancel");
		okButton = new JButton("OK");
	}
	
	@Override
	public void setDesign() {
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		Textid.setBounds(12, 10, 103, 15);
		contentPanel.add(Textid);
		
		Textname.setBounds(12, 50, 103, 15);
		contentPanel.add(Textname);
		
		Textdept.setBounds(12, 91, 103, 15);
		contentPanel.add(Textdept);
		
		Textjumin.setBounds(12, 128, 103, 15);
		contentPanel.add(Textjumin);
		
		id.setBounds(129, 6, 116, 21);
		contentPanel.add(id);
		id.setColumns(10);
		
		name.setBounds(129, 46, 116, 21);
		contentPanel.add(name);
		name.setColumns(10);
		
		dept.setBounds(129, 87, 116, 21);
		contentPanel.add(dept);
		dept.setColumns(10);
		
		jumin.setBounds(129, 124, 116, 21);
		contentPanel.add(jumin);
		jumin.setColumns(10);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public String getId() {
		return id.getText();
	}
	
	public void setId(JTextField id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name.getText();
	}
	
	public void setName(JTextField name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept.getText();
	}
	
	public void setDept(JTextField dept) {
		this.dept = dept;
	}
	
	public String getJumin() {
		return jumin.getText();
	}
	
	public void setJumin(JTextField jumin) {
		this.jumin = jumin;
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
