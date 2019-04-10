package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.CheckScoreService;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class CheckScoreHandler implements BaseController{
	
	private MainFrame uiMain;
	private CheckScoreService chkScoreService;
	private ActionListener update;
	private ActionListener back;
	private ActionListener logout;

	public CheckScoreHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		chkScoreService = new CheckScoreService();
		uiMain.getCheckScorePanel().setInfo(getScoreInfo());
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
		case "BACK":
			uiMain.setStudentPanel();
			new StudentHandler(uiMain);
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
	
	public String[][] getScoreInfo(){
		return chkScoreService.getScoreInfo(uiMain.getLoginPanel().getLogin_id());
	}

	@Override
	public void setEvent() {
		update = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CHANGEPW");
			}
		};
		
		logout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("LOGOUT");
			}
		};
		
		back = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("BACK");
			}
		};
	}

	@Override
	public void setListener() {
		uiMain.getCheckScorePanel().getBtnBack().addActionListener(back);
		uiMain.getCheckScorePanel().getBtnLogOut().addActionListener(logout);
		uiMain.getCheckScorePanel().getBtnUpdate().addActionListener(update);
	}

}
