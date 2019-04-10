package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

public class ClassManagerAddHandler extends ClassManagerAUDOController {

	public ClassManagerAddHandler(MainFrame uiMain) {
		super(uiMain);
		
		setEvent();
		setListener();
	}
	
	@Override
	public void setEvent() {
		ok = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!classManageService.getClassModel().compareSpace(uiMain.getClassManagerUpdate().getClassNo(), uiMain.getClassManagerUpdate().getClassName(), uiMain.getClassManagerUpdate().getChargeDept(), uiMain.getClassManagerUpdate().getScore()) || "".equals(uiMain.getClassManagerUpdate().getInfo())) {
					uiMain.getClassManagerUpdate().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(classManageService.checkClass(uiMain.getClassManagerUpdate().getClassNo())) {
					uiMain.getClassManagerUpdate().msgPrint("이미 존재하는 강좌입니다.");
					return;
				}
				
				if(!classManageService.deptCheck(uiMain.getClassManagerUpdate().getChargeDept())) {
					uiMain.getClassManagerUpdate().msgPrint("존재하지 않는 학과입니다.");
				}
				else {
					classManageService.insertClass(uiMain.getClassManagerUpdate().getClassNo(), uiMain.getClassManagerUpdate().getClassName(), uiMain.getClassManagerUpdate().getChargeDept(), uiMain.getClassManagerUpdate().getScore(), uiMain.getClassManagerUpdate().getInfo()); 
					uiMain.getClassManagerUpdate().msgPrint("생성 성공!");
					changePanel("REFRASH");
					uiMain.getClassManagerUpdate().dispose();
				}
			}
		};
		
		cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getClassManagerUpdate().dispose();
			}
		};
	}
	
	@Override
	public void setListener() {
		uiMain.getClassManagerUpdate().getOkButton().addActionListener(ok);
		uiMain.getClassManagerUpdate().getCancelButton().addActionListener(cancel);
	}
}
