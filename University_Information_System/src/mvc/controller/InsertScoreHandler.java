package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.InsertScoreService;
import mvc.view.MainFrame;

public class InsertScoreHandler implements BaseController{
	private MainFrame uiMain;
	private InsertScoreService insertScoreService;
	private ActionListener logout;
	private ActionListener back;
	private ActionListener insert;
	
	public InsertScoreHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		insertScoreService = new InsertScoreService(uiMain.getProfessorPanel().getclass_num());
		this.uiMain.getInsertScore().setTable(getInsertScoreService());
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
			uiMain.setProfessorPanel();
			new ProfessorHandler(uiMain);
			break;
		case "INSERT":
			String idNum = uiMain.getInsertScore().getIdInsert();
			if(!insertScoreService.checkInsertId(uiMain.getInsertScore().getIdInsert())) {
				uiMain.getInsertScore().msgPrint("학번을 입력해주세요.");
				break;
			}
			else if(!insertScoreService.checkClass(idNum)) {
				uiMain.getInsertScore().msgPrint("학번을 확인해주세요.");
				break;
			}
			
			String score = insertScoreService.checkInsertScore(uiMain.getInsertScore().getRdbtnA().isSelected(),
														uiMain.getInsertScore().getRdbtnB().isSelected(),
														uiMain.getInsertScore().getRdbtnC().isSelected(), 
														uiMain.getInsertScore().getRdbtnD().isSelected(),
														uiMain.getInsertScore().getRdbtnF().isSelected());
			
			if(score.length() > 2) {
				uiMain.getInsertScore().msgPrint(score);
				break;
			}
			
			String id = uiMain.getInsertScore().getIdInsert();
			String sc = insertScoreService.scoreApply(uiMain.getProfessorPanel().getclass_num(), id, score);
			if(sc.equals("scc")) {
				uiMain.getInsertScore().msgPrint("입력 완료");
				uiMain.setInsertScore();
				new InsertScoreHandler(uiMain);
			}
			else
				uiMain.getInsertScore().msgPrint("입력 실패");
			break;
		default:
			break;
		}
		uiMain.revalidate();
	}
	
	public String radioIsChecked() {
		if(uiMain.getInsertScore().getRdbtnA().isSelected()) {
			return "A";
		}
		if(uiMain.getInsertScore().getRdbtnB().isSelected()) {
			return "B";
		}
		if(uiMain.getInsertScore().getRdbtnC().isSelected()) {
			return "C";
		}
		if(uiMain.getInsertScore().getRdbtnD().isSelected()) {
			return "D";
		}
		if(uiMain.getInsertScore().getRdbtnF().isSelected()) {
			return "F";
		}
		return "성적을 선택해주세요";
	}
	
	
	public String[][] getInsertScoreService(){
		return insertScoreService.getLRService().getStr();
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
		
		insert = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("INSERT");
			}
		};
		
	}

	@Override
	public void setListener() {
		uiMain.getInsertScore().getBtnBack().addActionListener(back);
		uiMain.getInsertScore().getBtnLogOut().addActionListener(logout);
		uiMain.getInsertScore().getBtnInsert().addActionListener(insert);
	}
}
