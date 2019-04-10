package mvc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author 정영훈
 *
 */

public class LoginPanel extends JPanel implements BasePanel {
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JLabel Text_pw;
	private JButton login_button;
	private JTextField login_id;
	private JPasswordField passwordField;

	
	public LoginPanel() {
		setLayout(null);
		
		setComp();
		setDesign();
		
	}

	@Override
	public void setComp() {
		Text_PageName = new JLabel("대학정보종합시스템");
		Text_id = new JLabel("ID");
		login_id = new JTextField();
		Text_pw = new JLabel("PASSWORD");
		passwordField = new JPasswordField();
		login_button = new JButton("Login");
	}

	@Override
	public void setDesign() {
		Text_PageName.setForeground(Color.BLUE);
		Text_PageName.setFont(new Font("굴림", Font.PLAIN, 15));
		Text_PageName.setBounds(150, 34, 126, 18);
		add(Text_PageName);
		
		//id
		Text_id.setBounds(75, 80, 11, 15);
		add(Text_id);
		
		login_id.setBounds(75, 105, 116, 21);
		add(login_id);
		login_id.setColumns(10);
		
		//PASSWORD
		Text_pw.setBounds(75, 153, 116, 15);
		add(Text_pw);
		
		passwordField.setBounds(75, 178, 116, 21);
		add(passwordField);
		
		//로그인 버튼
		login_button.setBounds(239, 80, 116, 119);
		add(login_button);
	}

	public String getLogin_id() {
		return login_id.getText();
	}


	public String getPasswordField() {
		return String.valueOf(passwordField.getPassword());
	}

	public JButton getLogin_button() {
		return login_button;
	}

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
}
