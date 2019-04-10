package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class StudentHandler implements BaseController{
	private MainFrame uiMain;
	private ActionListener logout;
	private ActionListener apply;
	private ActionListener score;
	private ActionListener update;
	
	public StudentHandler(MainFrame uiMain) {
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
		case "CLASSAPPLY":
			uiMain.setClassApplyPanel();
			new ClassApplyHandler(uiMain);
			break;
		case "CHECKSCORE":
			uiMain.setCheckScorePanel();
			new CheckScoreHandler(uiMain);
			break;
		case "CHANGEPW":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
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
		
		apply = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CLASSAPPLY");
			}
		};
		
		score = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CHECKSCORE");
			}
		};
		
		update = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CHANGEPW");
			}
		};
	}

	@Override
	public void setListener() {
		uiMain.getStudentPanel().getBtnLogOut().addActionListener(logout);
		uiMain.getStudentPanel().getBtnApply().addActionListener(apply);
		uiMain.getStudentPanel().getBtnScore().addActionListener(score);
		uiMain.getStudentPanel().getBtnUpdate().addActionListener(update);
	}
	
	

}
