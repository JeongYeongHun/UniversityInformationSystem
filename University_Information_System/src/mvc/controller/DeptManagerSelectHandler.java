package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.ProfessorModel;
import mvc.model.StudentModel;
import mvc.model.User;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class DeptManagerSelectHandler implements BaseController {

	private MainFrame uiMain;
	private ActionListener logout;
	private ActionListener back;
	private ActionListener search;
	private ActionListener add;
	private ActionListener update;
	private ActionListener delete;
	private ActionListener modify;
	private User model;
	private int conType;
	
	public DeptManagerSelectHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		
		checkModel();
		
		setEvent();
		setListener();
		
	}
	
	public void checkModel() {
		if(uiMain.getContentPane() == uiMain.getDeptManagerStudentSelectPanel()) {
			model = new StudentModel();
			uiMain.getDeptManagerStudentSelectPanel().setInfo(model.getInfo());
			conType = 0;
		}
		if(uiMain.getContentPane() == uiMain.getDeptManagerProfessorSelectPanel()) {
			model = new ProfessorModel();
			uiMain.getDeptManagerProfessorSelectPanel().setInfo(model.getInfo());
			conType = 1;
		}
	}
	
	@Override
	public void changePanel(String type) {
		switch(type) {
		case "LOGOUT":
			uiMain.setLoginPanel();
			new LoginHandler(uiMain);
			break;
		case "BACK":
			uiMain.setDeptManagerPanel();
			new DeptManagerHandler(uiMain);
			break;
		case "UPDATE":
			uiMain.setDeptManagerUpdate();
			new DeptManagerUpdateHandler(uiMain);
			break;
		case "MODIFY":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
			break;
		case "DELETE":
			uiMain.setDeleteEmp();
			new DeptManagerDeleteHandler(uiMain);
			break;
		case "ADD":
			uiMain.setDeptManagerAdd();
			new DeptManagerAddHandler(uiMain);
			break;
		case "SEARCH":
			if(conType == 0 && uiMain.getDeptManagerStudentSelectPanel().getBtnNoRadio().isSelected() && !"".equals(uiMain.getDeptManagerStudentSelectPanel().getNoSearch())) {
				uiMain.getDeptManagerStudentSelectPanel().setInfo(model.searchNo(uiMain.getDeptManagerStudentSelectPanel().getNoSearch()));
			}	
			if(conType == 0 && uiMain.getDeptManagerStudentSelectPanel().getBtnNameRadio().isSelected() && !"".equals(uiMain.getDeptManagerStudentSelectPanel().getNameSearch())) {
				uiMain.getDeptManagerStudentSelectPanel().setInfo(model.searchName(uiMain.getDeptManagerStudentSelectPanel().getNameSearch()));
			}
				

			if(conType == 1 && uiMain.getDeptManagerProfessorSelectPanel().getBtnNoRadio().isSelected() && !"".equals(uiMain.getDeptManagerProfessorSelectPanel().getNoSearch())) {
				uiMain.getDeptManagerProfessorSelectPanel().setInfo(model.searchNo(uiMain.getDeptManagerProfessorSelectPanel().getNoSearch()));
			}
			if(conType == 1 && uiMain.getDeptManagerProfessorSelectPanel().getBtnNameRadio().isSelected() && !"".equals(uiMain.getDeptManagerProfessorSelectPanel().getNameSearch())) {
				uiMain.getDeptManagerProfessorSelectPanel().setInfo(model.searchName(uiMain.getDeptManagerProfessorSelectPanel().getNameSearch()));
			}
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
		
		modify = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("MODIFY");
			}
		};
		
		update = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("UPDATE");
			}
		};
		
		back = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("BACK");
			}
		};
		
		search = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("SEARCH");
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
		
	}
	
	@Override
	public void setListener() {
		if(conType == 0) {
			uiMain.getDeptManagerStudentSelectPanel().getBtnAdd().addActionListener(add);
			uiMain.getDeptManagerStudentSelectPanel().getBtnLogOut().addActionListener(logout);
			uiMain.getDeptManagerStudentSelectPanel().getBtnBack().addActionListener(back);
			uiMain.getDeptManagerStudentSelectPanel().getBtnUpdate().addActionListener(update);
			uiMain.getDeptManagerStudentSelectPanel().getBtnDelete().addActionListener(delete);
			uiMain.getDeptManagerStudentSelectPanel().getBtnSearch().addActionListener(search);
			uiMain.getDeptManagerStudentSelectPanel().getBtnModify().addActionListener(modify);
		}
		if(conType == 1) {
			uiMain.getDeptManagerProfessorSelectPanel().getBtnAdd().addActionListener(add);
			uiMain.getDeptManagerProfessorSelectPanel().getBtnLogOut().addActionListener(logout);
			uiMain.getDeptManagerProfessorSelectPanel().getBtnBack().addActionListener(back);
			uiMain.getDeptManagerProfessorSelectPanel().getBtnUpdate().addActionListener(update);
			uiMain.getDeptManagerProfessorSelectPanel().getBtnDelete().addActionListener(delete);
			uiMain.getDeptManagerProfessorSelectPanel().getBtnSearch().addActionListener(search);
			uiMain.getDeptManagerProfessorSelectPanel().getBtnModify().addActionListener(modify);
		}
	}
	
}
