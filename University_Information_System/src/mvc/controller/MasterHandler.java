package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.MasterModel;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class MasterHandler implements BaseController {

	private MainFrame uiMain;
	private MasterModel masterModel;
	private ActionListener logout;
	private ActionListener update;
	private ActionListener insert;
	private ActionListener delete;
	private ActionListener modify;
	
	public MasterHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		masterModel = new MasterModel();
		uiMain.getMasterPanel().setInfo(masterModel.getInfo());
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
		case "CHANGEPW":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
			break;
		case "MODIFY":
			uiMain.setModifyEmp();
			new ModifyEmpHandler(uiMain);
			break;
		case "DELETE":
			uiMain.setDeleteEmp();
			new DeleteEmpHandler(uiMain);
			break;
		case "ADD":
			uiMain.setModifyEmp();
			new AddEmpHandler(uiMain);
			break;
		default:
			break;
		}
		uiMain.revalidate();
	}

	@Override
	public void setEvent() {
		
		delete = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("DELETE");
			}
		};
		
		insert = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("ADD");
			}
		};
		
		update = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CHANGEPW");
			}
		};
		
		modify = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("MODIFY");
			}
		};
		
		logout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("LOGOUT");
			}
		};
	}

	@Override
	public void setListener() {
		uiMain.getMasterPanel().getBtnInsert().addActionListener(insert);
		uiMain.getMasterPanel().getBtnLogOut().addActionListener(logout);
		uiMain.getMasterPanel().getBtnUpdate().addActionListener(update);
		uiMain.getMasterPanel().getBtnModify().addActionListener(modify);
		uiMain.getMasterPanel().getBtnDelete().addActionListener(delete);
	}

}
