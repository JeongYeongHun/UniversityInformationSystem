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

public class ClassManagerDeleteDialog extends JDialog implements BasePanel {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel textClassNo;
	private JTextField classNo;

	public ClassManagerDeleteDialog() {
		getContentPane().setLayout(new BorderLayout());
		setBounds(100, 100, 263, 124);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		buttonPane = new JPanel();
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		textClassNo = new JLabel("삭제할 강좌번호");
		classNo = new JTextField();
	}
	
	@Override
	public void setDesign() {
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		textClassNo.setBounds(12, 10, 103, 15);
		contentPanel.add(textClassNo);
		
		classNo.setBounds(115, 6, 116, 21);
		contentPanel.add(classNo);
		classNo.setColumns(10);
		
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

	public String getClassNo() {
		return classNo.getText();
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
