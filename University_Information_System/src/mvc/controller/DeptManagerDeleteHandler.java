package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class DeptManagerDeleteHandler extends DeptManagerADUController{
	
	public DeptManagerDeleteHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		
		checkModel();
		setEvent();
		setListener();
	}
	
	@Override
	public void setEvent() {
		this.ok = new ActionListener() {
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
				
				if(model.compare(uiMain.getDeleteEmp().getId())) {
					model.delete("no", uiMain.getDeleteEmp().getId());
					uiMain.getDeleteEmp().msgPrint("삭제 성공!");
					changePanel("REFRASH");
					uiMain.getDeleteEmp().dispose();
				}
			}
		};
		
		this.cancel = new ActionListener() {
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
