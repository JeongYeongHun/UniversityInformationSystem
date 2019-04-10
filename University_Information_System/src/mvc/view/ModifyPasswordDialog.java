package mvc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * @author 정영훈
 *
 */

public class ModifyPasswordDialog extends JDialog implements BasePanel{

	private final JPanel contentPanel = new JPanel();
	private JPasswordField newPassword;
	private JPasswordField checkPassword;
	private JLabel label;
	private JLabel lblNewLabel;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	public ModifyPasswordDialog() {
		setBounds(100, 100, 282, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setComp();
		setDesign();
		
	}

	@Override
	public void setComp() {
		label = new JLabel("변경할 비밀번호");
		newPassword = new JPasswordField();
		lblNewLabel = new JLabel("비밀번호 확인");
		checkPassword = new JPasswordField();
		buttonPane = new JPanel();
		okButton = new JButton("OK");
		
		cancelButton = new JButton("Cancel");
		
		
	}

	@Override
	public void setDesign() {
		label.setBounds(12, 10, 111, 15);
		contentPanel.add(label);
		
		newPassword.setBounds(12, 35, 149, 21);
		contentPanel.add(newPassword);
		
		lblNewLabel.setBounds(12, 71, 111, 15);
		contentPanel.add(lblNewLabel);
		
		checkPassword.setBounds(12, 96, 149, 21);
		contentPanel.add(checkPassword);
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
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

	public JPasswordField getNewPassword() {
		return newPassword;
	}

	public JPasswordField getCheckPassword() {
		return checkPassword;
	}
	
}
