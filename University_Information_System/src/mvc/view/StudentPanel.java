package mvc.view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

/**
 * @author 정영훈
 *
 */

public class StudentPanel extends JPanel implements BasePanel{
	private JLabel Text_PageName;
	private JLabel Text_id;
	private JButton btnLogOut;
	private JButton btnApply;
	private JButton btnScore;
	private JButton btnUpdate;
	private String id;
	
	public StudentPanel(String id) {
		this.id = id;
		setLayout(null);
	
		setComp();
		setDesign();
	}


	@Override
	public void setComp() {
		Text_PageName = new JLabel("학생 화면");
		Text_id = new JLabel(id);
		btnLogOut = new JButton("로그아웃");
		btnApply = new JButton("수강신청");
		btnScore = new JButton("성적확인");
		btnUpdate = new JButton("정보변경");
		
	}


	@Override
	public void setDesign() {
		Text_PageName.setBounds(12, 10, 57, 15);
		add(Text_PageName);
		
		Text_id.setBounds(151, 10, 57, 15);
		add(Text_id);
		
		btnLogOut.setBounds(307, 6, 93, 23);
		add(btnLogOut);
		
		
		btnApply.setBounds(57, 57, 97, 73);
		add(btnApply);
		
		
		btnScore.setBounds(248, 57, 97, 73);
		add(btnScore);
		
		
		btnUpdate.setBounds(210, 6, 93, 23);
		add(btnUpdate);
	}


	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnApply() {
		return btnApply;
	}


	public JButton getBtnScore() {
		return btnScore;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
}
