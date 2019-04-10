package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

public class ClassManagerOpenHandler extends ClassManagerAUDOController {

	public ClassManagerOpenHandler(MainFrame uiMain) {
		super(uiMain);
		setEvent();
		setListener();
	}

	
	@Override
	public void setEvent() {
		ok = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!classManageService.getClassModel().compareSpace(uiMain.getClassManagerOpen().getClassNo(), uiMain.getClassManagerOpen().getChargeProf(), uiMain.getClassManagerOpen().getMinStud(), uiMain.getClassManagerOpen().getMaxStud())) {
					uiMain.getClassManagerOpen().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(!classManageService.checkClass(uiMain.getClassManagerOpen().getClassNo())) {
					uiMain.getClassManagerOpen().msgPrint("존재하지 않는 강좌입니다.");
					return;
				}
				
				if(!classManageService.openCheck(uiMain.getClassManagerOpen().getClassNo())) {
					uiMain.getClassManagerOpen().msgPrint("이미 개설된 강의 입니다.");
				}
				else {
					classManageService.openClass(uiMain.getClassManagerOpen().getClassNo(), uiMain.getClassManagerOpen().getChargeProf(), uiMain.getClassManagerOpen().getMinStud(), uiMain.getClassManagerOpen().getMaxStud()); 
					uiMain.getClassManagerOpen().msgPrint("개설 성공!");
					changePanel("REFRASH");
					uiMain.getClassManagerOpen().dispose();
				}
			}
		};
		
		cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getClassManagerOpen().dispose();
			}
		};
	}
	
	@Override
	public void setListener() {
		uiMain.getClassManagerOpen().getOkButton().addActionListener(ok);
		uiMain.getClassManagerOpen().getCancelButton().addActionListener(cancel);
	}
}
