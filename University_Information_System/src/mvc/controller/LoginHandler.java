package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.LoginService;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class LoginHandler implements BaseController{
	private MainFrame uiMain;
	private LoginService login;
	private ActionListener listener;
	
	public LoginHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		setEvent();
		setListener();
	}
	
	public boolean login() {
			login = new LoginService(uiMain.getLoginPanel().getLogin_id(), uiMain.getLoginPanel().getPasswordField());
			if(login.login()) {
				//성공시
				changePanel(login.getIdType());
				return true;
			}
			else {
				//실패시
				return false;
			}
	}
	
	@Override
	public void changePanel(String type) {
		switch(type) {
			case "STUDENT_INFO":
				uiMain.setStudentPanel();
				new StudentHandler(uiMain);
				break;
			case "PROFESSOR_INFO":
				uiMain.setProfessorPanel();
				new ProfessorHandler(uiMain);
				break;
			case "DEPT_MANAGER_INFO":
				uiMain.setDeptManagerPanel();
				new DeptManagerHandler(uiMain);
				break;
			case "CLASS_MANAGER_INFO":
				uiMain.setClassManagerPanel();
				new ClassManagerHandler(uiMain);
				break;
			case "MASTER":
				uiMain.setMasterPanel();
				new MasterHandler(uiMain);
				break;
			default:
				break;
		}
		uiMain.revalidate();
	}

	
	
	public void setEvent() {
		listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("".equals(uiMain.getLoginPanel().getLogin_id())) {
					uiMain.getLoginPanel().msgPrint("아이디를 입력해주세요");
					return;
				}
				
				if("".equals(uiMain.getLoginPanel().getPasswordField())) {
					uiMain.getLoginPanel().msgPrint("비밀번호를 입력해주세요");
					return;
				}
	
				if(!login()) {
					uiMain.getLoginPanel().msgPrint("계정 정보를 확인해주세요");
				}
			}
		};
	}
	
	public void setListener() {
		uiMain.getLoginPanel().getLogin_button().addActionListener(listener);
	}
	
	
}
