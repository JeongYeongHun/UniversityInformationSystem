package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.MasterModel;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class DeleteEmpHandler extends EmpManageController{
	
	public DeleteEmpHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		model = new MasterModel();
		setEvent();
		setListener();
	}

	@Override
	public void setEvent() {
		ok = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(uiMain.getDeleteEmp().getId())) {
					uiMain.getDeleteEmp().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(model.checkID(uiMain.getDeleteEmp().getId())) {
					uiMain.getDeleteEmp().msgPrint("존재하지 않는 아이디입니다.");
					return;
				}
				
				if(model.compareDmanager(uiMain.getDeleteEmp().getId())) {
					model.deleteDeptManager("NO", uiMain.getDeleteEmp().getId());
					uiMain.getDeleteEmp().msgPrint("삭제 성공!");
					changePanel("REFRASH");
					uiMain.getDeleteEmp().dispose();
					return;
				}
				
				if(model.compareCmanager(uiMain.getDeleteEmp().getId())) {
					model.deleteClassManager("NO", uiMain.getDeleteEmp().getId());
					uiMain.getDeleteEmp().msgPrint("삭제 성공!");
					changePanel("REFRASH");
					uiMain.getDeleteEmp().dispose();
				}
			}
		};
		
		cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getDeleteEmp().dispose();
			}
		};
		
	}

	@Override
	public void setListener() {
		uiMain.getDeleteEmp().getOkButton().addActionListener(ok);
		uiMain.getDeleteEmp().getCancelButton().addActionListener(cancel);
	}

}
