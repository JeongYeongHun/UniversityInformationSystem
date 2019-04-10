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
import javax.swing.JTextPane;

public class ClassManagerUpdateDialog extends JDialog implements BasePanel {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel textClassNo;
	private JLabel textInfo;
	private JLabel textClassName;
	private JLabel textChargeDept;
	private JLabel textScore;
	private JTextField score;
	private JTextField info;
	private JTextField classNo;
	private JTextField chargeDept;
	private JTextField className;
	

	public ClassManagerUpdateDialog() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 276, 343);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		buttonPane = new JPanel();
		
		textInfo = new JLabel("설명");
		info = new JTextField();
		
		okButton = new JButton("OK");
		
		classNo = new JTextField();
		textClassNo = new JLabel("강좌번호");

		className = new JTextField();
		textClassName = new JLabel("강좌명");

		chargeDept = new JTextField();
		textChargeDept = new JLabel("학과");

		score = new JTextField();
		textScore = new JLabel("학점수");
		
		cancelButton = new JButton("Cancel");
	}
	
	@Override
	public void setDesign() {
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		textClassNo.setBounds(12, 10, 103, 15); 
		contentPanel.add(textClassNo);
		
		textChargeDept.setBounds(12, 91, 103, 15);
		contentPanel.add(textChargeDept);
		
		textClassName.setBounds(12, 50, 103, 15);
		contentPanel.add(textClassName);
		
		textScore.setBounds(12, 128, 103, 15);
		contentPanel.add(textScore);
		
		classNo.setBounds(129, 6, 116, 21);
		contentPanel.add(classNo);
		classNo.setColumns(10);
		
		className.setBounds(129, 46, 116, 21);
		contentPanel.add(className);
		className.setColumns(10);
		
		chargeDept.setBounds(129, 87, 116, 21);
		contentPanel.add(chargeDept);
		chargeDept.setColumns(10);
		
		score.setBounds(129, 124, 116, 21);
		contentPanel.add(score);
		score.setColumns(10);
		
		textInfo.setBounds(12, 168, 103, 15);
		info.setBounds(129, 164, 116,97);
		
		contentPanel.add(textInfo);
		contentPanel.add(info);
		info.setColumns(100);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public String getClassNo() {
		return classNo.getText();
	}
	
	public void setClassNo(JTextField classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className.getText();
	}
	
	public void setClassName(JTextField className) {
		this.className = className;
	}
	
	public String getChargeDept() {
		return chargeDept.getText();
	}
	
	public void setChargeDept(JTextField chargeDept) {
		this.chargeDept = chargeDept;
	}
	
	public String getScore() {
		return score.getText();
	}
	
	public void setScore(JTextField score) {
		this.score = score;
	}
	
	public String getInfo() {
		return info.getText();
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
