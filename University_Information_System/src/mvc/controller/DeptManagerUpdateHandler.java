package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class DeptManagerUpdateHandler extends DeptManagerADUController{
	
	public DeptManagerUpdateHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		
		checkModel();
		setEvent();
		setListener();
	}
	
	@Override
	public void setEvent() {
		this.ok = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!model.compareSpace(uiMain.getDeptManagerUpdate().getId(), uiMain.getDeptManagerUpdate().getName(), uiMain.getDeptManagerUpdate().getDept(), uiMain.getDeptManagerUpdate().getJumin())) {
					uiMain.getDeptManagerUpdate().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(!Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", uiMain.getDeptManagerUpdate().getJumin())) {
					uiMain.getDeptManagerUpdate().msgPrint("유효한 주민등록번호가 아닙니다.");
					return;
				}
				
				if(model.checkID(uiMain.getDeptManagerUpdate().getId())) {
					uiMain.getDeptManagerUpdate().msgPrint("존재하지 않는 아이디입니다.");
					return;
				}
				
				if(!model.deptCheck(uiMain.getDeptManagerUpdate().getDept())) {
					uiMain.getDeptManagerUpdate().msgPrint("존재하지 않는 학과입니다.");
					return;
				}
				
				if(model.compare(uiMain.getDeptManagerUpdate().getId())) {
					model.update(uiMain.getDeptManagerUpdate().getId(), uiMain.getDeptManagerUpdate().getName(), uiMain.getDeptManagerUpdate().getDept(), uiMain.getDeptManagerUpdate().getJumin());
					uiMain.getDeptManagerUpdate().msgPrint("수정 성공!");
					changePanel("REFRASH");
					uiMain.getDeptManagerUpdate().dispose();
				}
				else {
					uiMain.getDeptManagerUpdate().msgPrint("규칙에 어긋나는 아이디입니다.");
				}
			}
		};
		
		this.cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getDeptManagerUpdate().dispose();
			}
		};
		
	}
	
	@Override
	public void setListener() {
		uiMain.getDeptManagerUpdate().getOkButton().addActionListener(ok);
		uiMain.getDeptManagerUpdate().getCancelButton().addActionListener(cancel);
	}
}
