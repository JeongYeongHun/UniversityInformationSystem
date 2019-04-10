package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.MainFrame;

public class ClassManagerDeleteHandler extends ClassManagerAUDOController{

	public ClassManagerDeleteHandler(MainFrame uiMain) {
		super(uiMain);
		setEvent();
		setListener();
	}

	@Override
	public void setEvent() {
		ok = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(uiMain.getClassManagerDelete().getClassNo())) {
					uiMain.getClassManagerDelete().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(!classManageService.checkClass(uiMain.getClassManagerDelete().getClassNo())) {
					uiMain.getClassManagerDelete().msgPrint("존재하지 않는 강좌번호입니다.");
				}
				else {
					classManageService.deleteClass("class_no", uiMain.getClassManagerDelete().getClassNo()); 
					uiMain.getClassManagerDelete().msgPrint("삭제 성공!");
					changePanel("REFRASH");
					uiMain.getClassManagerDelete().dispose();
				}
			}
		};
		
		cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getClassManagerDelete().dispose();
			}
		};
	}
	
	@Override
	public void setListener() {
		uiMain.getClassManagerDelete().getOkButton().addActionListener(ok);
		uiMain.getClassManagerDelete().getCancelButton().addActionListener(cancel);
	}
}
