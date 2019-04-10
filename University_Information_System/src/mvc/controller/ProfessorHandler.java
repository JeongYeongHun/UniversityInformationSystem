package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.ProfessorService;
import mvc.view.MainFrame;

public class ProfessorHandler implements BaseController {
	
	private MainFrame uiMain;
	private ProfessorService professorService;
	private ActionListener logout;
	private ActionListener getlist;
	private ActionListener getroll;
	private ActionListener insertscore;
	private ActionListener update;
	
	public ProfessorHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		professorService = new ProfessorService(uiMain.getLoginPanel().getLogin_id());
		this.uiMain.getProfessorPanel().setTable(professorService.getStr());
		setEvent();
		setListener();
	}

	@Override
	public void changePanel(String type) {
		String classNum = uiMain.getProfessorPanel().getclass_num();
		String msg = "강좌를 다시 확인하세요";
		switch(type) {
		case "LOGOUT":
			uiMain.setLoginPanel();
			new LoginHandler(uiMain);
			break;	
		case "CHANGEPW":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
			break;
		case "GETROLL":
			if(professorService.checkClass(classNum)) {
				uiMain.setGetRoll();
				new GetListRollHandler(uiMain);
			}
			else uiMain.getProfessorPanel().msgPrint(msg);
			break;
		case "GETLIST":
			if(professorService.checkClass(classNum)) {
				uiMain.setGetList();
				new GetListRollHandler(uiMain);
			}
			else uiMain.getProfessorPanel().msgPrint(msg);
			break;
		case "INSERTSCORE":
			if(professorService.checkDate()) {
				if(professorService.checkClass(classNum)) {
					uiMain.setInsertScore();
					new InsertScoreHandler(uiMain);
				}
				else uiMain.getProfessorPanel().msgPrint(msg);
			}
			else uiMain.getProfessorPanel().msgPrint("아직 학기가 종료되지 않았습니다.");
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
		
		getlist = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("GETLIST");
			}
		};
		
		getroll = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("GETROLL");
			}
		};
		
		insertscore = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("INSERTSCORE");
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
		uiMain.getProfessorPanel().getBtnLogOut().addActionListener(logout);
		uiMain.getProfessorPanel().getBtnRoll().addActionListener(getroll);
		uiMain.getProfessorPanel().getBtnList().addActionListener(getlist);
		uiMain.getProfessorPanel().getBtnScore().addActionListener(insertscore);
		uiMain.getProfessorPanel().getBtnUpdate().addActionListener(update);
	}
}
