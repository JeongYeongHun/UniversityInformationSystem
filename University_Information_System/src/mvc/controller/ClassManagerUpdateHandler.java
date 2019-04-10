package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

public class ClassManagerUpdateHandler extends ClassManagerAUDOController {

	public ClassManagerUpdateHandler(MainFrame uiMain) {
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
				if(!classManageService.checkClass(uiMain.getClassManagerUpdate().getClassNo())) {
					uiMain.getClassManagerUpdate().msgPrint("존재하지 않는 강좌입니다.");
					return;
				}
				if(!classManageService.deptCheck(uiMain.getClassManagerUpdate().getChargeDept())) {
					uiMain.getClassManagerUpdate().msgPrint("존재하지 않는 학과입니다.");
					return;
				}
				if(!classManageService.openCheck(uiMain.getClassManagerUpdate().getClassNo())) {
					uiMain.getClassManagerUpdate().msgPrint("이미 개설된 강의 입니다.");
				}
				else {
					classManageService.updateClass(uiMain.getClassManagerUpdate().getClassNo(), uiMain.getClassManagerUpdate().getClassName(), uiMain.getClassManagerUpdate().getChargeDept(), uiMain.getClassManagerUpdate().getScore(), uiMain.getClassManagerUpdate().getInfo()); 
					uiMain.getClassManagerUpdate().msgPrint("수정 성공!");
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
