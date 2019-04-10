package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DeptManagerPanel extends JPanel implements BasePanel {

	private JLabel Text_PageName;
	private JLabel Text_id;
	private JButton btnLogOut;
	private JButton btnStudent;
	private JButton btnProfessor;
	private String id;
	private JButton btnModify;
	
	public DeptManagerPanel(String id) {
		this.id = id;
		setLayout(null);
	
		setComp();
		setDesign();
	}


	@Override
	public void setComp() {
		Text_PageName = new JLabel("학사담당자 화면");
		Text_id = new JLabel(id);
		btnLogOut = new JButton("로그아웃");
		btnStudent = new JButton("학생");
		btnProfessor = new JButton("교수");
		btnModify = new JButton("정보변경");
	}


	@Override
	public void setDesign() {
		Text_PageName.setBounds(12, 10, 103, 15);
		add(Text_PageName);
		
		Text_id.setBounds(138, 10, 74, 15);
		add(Text_id);
		
		btnLogOut.setBounds(311, 6, 93, 23);
		add(btnLogOut);
		
		
		btnStudent.setBounds(80, 118, 97, 73);
		add(btnStudent);
		
		
		btnProfessor.setBounds(222, 118, 97, 73);
		add(btnProfessor);
		
		btnModify.setBounds(202, 6, 97, 23);
		add(btnModify);
	}


	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnStudent() {
		return btnStudent;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public JButton getBtnProfessor() {
		return btnProfessor;
	}

}
