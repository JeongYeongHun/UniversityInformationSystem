package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mvc.model.ClassManageService;
import mvc.view.MainFrame;

public class ClassManagerHandler implements BaseController {

	private MainFrame uiMain;
	private MouseListener scroll;
	private ActionListener logout;
	private ActionListener open;
	private ActionListener add;
	private ActionListener update;
	private ActionListener delete;
	private ActionListener modify;
	private ActionListener bill;
	private ClassManageService classManageService; // '강좌 조회'를 위한 테이블값 불러오기
	private String[] strinfo;
	
	public ClassManagerHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		classManageService = new ClassManageService();
		classManageService.modelToString();
		this.uiMain.getClassManagerPanel().setTable(getClassManageService());
		strinfo = getClassManageInfoService();
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
		case "UPDATE":
			uiMain.setClassManagerUpdate();
			new ClassManagerUpdateHandler(uiMain);
			break;
		case "DELETE":
			uiMain.setClassManagerDelete();
			new ClassManagerDeleteHandler(uiMain);
			break;
		case "ADD":
			uiMain.setClassManagerUpdate();
			new ClassManagerAddHandler(uiMain);
			break;
		case "OPEN":
			uiMain.setClassManagerOpen();
			new ClassManagerOpenHandler(uiMain);
			break;
		case "MODIFY":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
			break;
		case "BILL":
			uiMain.setBillSendPanel();
			new BillSendHandler(uiMain);
			break;
		default:
			break;
		}
		uiMain.revalidate();
	}
	
	public String[][] getClassManageService() {
		return classManageService.getStr();
	}
	
	public String[] getClassManageInfoService() {
		return classManageService.getStrinfo();
	}
	
	@Override
	public void setEvent() {
		scroll = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uiMain.getClassManagerPanel().msgPrint(strinfo[uiMain.getClassManagerPanel().getSelected()]);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				//미필요
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//미필요
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//미필요
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				//미필요
			}
			
		};
		
		add = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("ADD");
			}
		};
		
		delete = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("DELETE");
			}
		};
		
		logout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("LOGOUT");
			}
		};
		
		update = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("UPDATE");
			}
		};
		
		open = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("OPEN");
			}
		};
		
		modify = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanel("MODIFY");
			}
		};
		
		bill = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanel("BILL");
			}
		};
	}

	@Override
	public void setListener() {
		uiMain.getClassManagerPanel().getScrollPane().getViewport().getView().addMouseListener(scroll);
		uiMain.getClassManagerPanel().getBtnLogOut().addActionListener(logout);
		uiMain.getClassManagerPanel().getBtnAdd().addActionListener(add);
		uiMain.getClassManagerPanel().getBtnUpdate().addActionListener(update);
		uiMain.getClassManagerPanel().getBtnDelete().addActionListener(delete);
		uiMain.getClassManagerPanel().getBtnOpen().addActionListener(open);
		uiMain.getClassManagerPanel().getBtnModify().addActionListener(modify);
		uiMain.getClassManagerPanel().getBillSend().addActionListener(bill);
	}
}
