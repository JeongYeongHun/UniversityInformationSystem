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

public class DeleteEmpDialog extends JDialog implements BasePanel{

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel Textid;
	private JTextField id;
	private JButton okButton;
	private JButton cancelButton;

	public DeleteEmpDialog() {
		setBounds(100, 100, 290, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
					
		setComp();
		setDesign();
		
	}

	@Override
	public void setComp() {
		buttonPane = new JPanel();
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		Textid = new JLabel("삭제할 아이디");
		id = new JTextField();
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
		
		Textid.setBounds(12, 10, 116, 15);
		contentPanel.add(Textid);
		
		id.setBounds(140, 7, 116, 21);
		contentPanel.add(id);
		id.setColumns(10);
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

	@Override
	public void msgPrint(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

}
