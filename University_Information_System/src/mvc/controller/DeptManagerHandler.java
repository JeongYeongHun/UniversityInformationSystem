package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

public class DeptManagerHandler implements BaseController {
	private MainFrame uiMain;
	private ActionListener logout;
	private ActionListener student;
	private ActionListener professor;
	private ActionListener modify;
	
	public DeptManagerHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		setEvent();
		setListener();
	}
	
	@Override
	public void changePanel(String type) {
		switch(type) {
		case "LOGOUT":
			uiMain.setLoginPanel();
			new LoginHandler(uiMain);
			break;	
		case "MODIFY":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
			break;
		case "STUDENT":
			uiMain.setDeptManagerStudentSelectPanel();
			new DeptManagerSelectHandler(uiMain);
			break;
		case "PROFESSOR":
			uiMain.setDeptManagerProfessorSelectPanel();
			new DeptManagerSelectHandler(uiMain);
			break;
		default:
			break;
		}
		uiMain.revalidate();
		
	}
	
	@Override
	public void setEvent() {
		logout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("LOGOUT");
			}
		};
		
		student = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("STUDENT");
			}
		};
		
		professor = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("PROFESSOR");
			}
		};
		
		modify = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("MODIFY");
			}
		};
	}
	
	@Override
	public void setListener() {
		uiMain.getDeptManagerPanel().getBtnLogOut().addActionListener(logout);
		uiMain.getDeptManagerPanel().getBtnStudent().addActionListener(student);
		uiMain.getDeptManagerPanel().getBtnProfessor().addActionListener(professor);
		uiMain.getDeptManagerPanel().getBtnModify().addActionListener(modify);
	}
}
