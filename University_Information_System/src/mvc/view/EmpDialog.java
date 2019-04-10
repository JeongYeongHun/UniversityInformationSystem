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

/**
 * @author 정영훈
 *
 */

public class EmpDialog extends JDialog implements BasePanel{

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField id;
	private JTextField name;
	private JTextField pw;
	private JLabel Textpw;
	private JLabel Textname;
	private JLabel Textid;
	
	public EmpDialog() {
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
					
		setComp();
		setDesign();
		
	}

	@Override
	public void setComp() {
		Textid = new JLabel("아이디");
		id = new JTextField();
		
		buttonPane = new JPanel();
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		Textpw = new JLabel("주민등록번호");
		pw = new JTextField();
		
		Textname = new JLabel("이름");
		name = new JTextField();
	}

	@Override
	public void setDesign() {
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		Textid.setBounds(12, 10, 87, 15);
		contentPanel.add(Textid);
		
		Textpw.setBounds(12, 90, 87, 15);
		contentPanel.add(Textpw);
		
		Textname.setBounds(12, 50, 96, 15);
		contentPanel.add(Textname);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		id.setBounds(111, 7, 161, 21);
		contentPanel.add(id);
		id.setColumns(10);
		
		pw.setBounds(111, 87, 161, 21);
		contentPanel.add(pw);
		pw.setColumns(10);
		
		name.setBounds(111, 47, 161, 21);
		contentPanel.add(name);
		name.setColumns(10);
	}

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
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

	public String getPw() {
		return pw.getText();
	}

	public void setPw(JTextField pw) {
		this.pw = pw;
	}

	@Override
	public String getName() {
		return name.getText();
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	

	
}
