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

public class ClassManagerOpenDialog extends JDialog implements BasePanel {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel textClassNo;
	private JLabel textChargeProf;
	private JLabel textMaxStud;
	private JLabel textMinStud;
	private JTextField classNo;
	private JTextField chargeProf;
	private JTextField minStud;
	private JTextField maxStud;
	private JButton okButton;
	private JButton cancelButton;


	public ClassManagerOpenDialog() {
		setBounds(100, 100, 242, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		textMinStud = new JLabel("최소인원수");
		minStud = new JTextField();
		textMaxStud = new JLabel("최대인원수");
		textClassNo = new JLabel("강좌번호");
		classNo = new JTextField();
		textChargeProf = new JLabel("담당교수");
		chargeProf = new JTextField();
		maxStud = new JTextField();
		buttonPane = new JPanel();
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
	}
	
	@Override
	public void setDesign() {
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		textClassNo.setBounds(12, 10, 73, 15);
		contentPanel.add(textClassNo);
		
		classNo.setBounds(97, 6, 116, 21);
		contentPanel.add(classNo);
		classNo.setColumns(10);
		
		textChargeProf.setBounds(12, 43, 73, 15);
		contentPanel.add(textChargeProf);
		
		chargeProf.setBounds(97, 39, 116, 21);
		contentPanel.add(chargeProf);
		chargeProf.setColumns(10);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		minStud.setBounds(97, 72, 116, 21);
		contentPanel.add(minStud);
		minStud.setColumns(10);
		
		textMinStud.setBounds(12, 76, 73, 15);
		contentPanel.add(textMinStud);
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		textMaxStud.setBounds(12, 109, 73, 15);
		contentPanel.add(textMaxStud);
		
		maxStud.setBounds(97, 105, 116, 21);
		contentPanel.add(maxStud);
		maxStud.setColumns(10);
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

	public String getChargeProf() {
		return chargeProf.getText();
	}

	public String getMinStud() {
		return minStud.getText();
	}

	public String getMaxStud() {
		return maxStud.getText();
	}
	
	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
