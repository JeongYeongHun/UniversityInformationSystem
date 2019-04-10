package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import mvc.model.MasterModel;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class ModifyEmpHandler extends EmpManageController{

	public ModifyEmpHandler(MainFrame uiMain) {
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
				if(!model.compareSpace(uiMain.getModifyEmp().getId(), uiMain.getModifyEmp().getPw(), uiMain.getModifyEmp().getName())) {
					uiMain.getModifyEmp().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(!Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", uiMain.getModifyEmp().getPw())) {
					uiMain.getModifyEmp().msgPrint("유효한 주민등록번호가 아닙니다.");
					return;
				}
				
				if(model.checkID(uiMain.getModifyEmp().getId())) {
					uiMain.getModifyEmp().msgPrint("존재하지 않는 아이디입니다.");
					return;
				}
				
				if(model.compareDmanager(uiMain.getModifyEmp().getId())) {
					model.updateDeptManager(uiMain.getModifyEmp().getName(), uiMain.getModifyEmp().getId(), uiMain.getModifyEmp().getPw());
					uiMain.getModifyEmp().msgPrint("업데이트 성공!");
					changePanel("REFRASH");
					uiMain.getModifyEmp().dispose();
					return;
				}
				
				if(model.compareCmanager(uiMain.getModifyEmp().getId())) {
					model.updateClassManager(uiMain.getModifyEmp().getName(), uiMain.getModifyEmp().getId(), uiMain.getModifyEmp().getPw());
					uiMain.getModifyEmp().msgPrint("업데이트 성공!");
					changePanel("REFRASH");
					uiMain.getModifyEmp().dispose();
				}
				
			}
		};
		
		cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getModifyEmp().dispose();
			}
		};
		
	}

	@Override
	public void setListener() {
		uiMain.getModifyEmp().getOkButton().addActionListener(ok);
		uiMain.getModifyEmp().getCancelButton().addActionListener(cancel);
	}

}
