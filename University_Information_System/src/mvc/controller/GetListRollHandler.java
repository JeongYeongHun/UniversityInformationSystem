package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.GetListRollService;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class GetListRollHandler implements BaseController{
	private MainFrame uiMain;
	private int conType;
	private GetListRollService getLRservice;
	private ActionListener logout;
	private ActionListener back;
	
	public GetListRollHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		getLRservice = new GetListRollService(uiMain.getProfessorPanel().getclass_num());
		
		checkService();
		
		setEvent();
		setListener();
	
	}
	
	public void checkService() {
		if(uiMain.getContentPane() == uiMain.getGetList()) {
			uiMain.getGetList().setTable(getGetListService());
			conType = 0;
		}
		if(uiMain.getContentPane() == uiMain.getGetRoll()) {
			uiMain.getGetRoll().setTable(getGetRollService());
			conType = 1;
		}
	}
	
	public String[][] getGetListService(){
		getLRservice.lmodelToString();
		return getLRservice.getStr();
	}
	
	public String[][] getGetRollService(){
		getLRservice.rmodelToString();
		return getLRservice.getStr();
	}
	
	
	@Override
	public void changePanel(String type) {
		switch(type) {
		case "LOGOUT":
			uiMain.setLoginPanel();
			new LoginHandler(uiMain);
			break;	
		case "BACK":
			uiMain.setProfessorPanel();
			new ProfessorHandler(uiMain);
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
		
		back = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("BACK");
			}
		};
		
	}

	@Override
	public void setListener() {
		if(conType == 0) {
			uiMain.getGetList().getBtnBack().addActionListener(back);
			uiMain.getGetList().getBtnLogOut().addActionListener(logout);
		}
		if(conType == 1) {
			uiMain.getGetRoll().getBtnBack().addActionListener(back);
			uiMain.getGetRoll().getBtnLogOut().addActionListener(logout);
		}
		
	}
}
