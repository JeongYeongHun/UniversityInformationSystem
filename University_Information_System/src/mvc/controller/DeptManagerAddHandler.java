package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class DeptManagerAddHandler extends DeptManagerADUController{

	
	public DeptManagerAddHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		
		checkModel();
		setEvent();
		setListener();
	}
	
	@Override
	public void setEvent() {
		this.ok = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!model.compareSpace(uiMain.getDeptManagerAdd().getId(), uiMain.getDeptManagerAdd().getName(), uiMain.getDeptManagerAdd().getDept(), uiMain.getDeptManagerAdd().getJumin())) {
					uiMain.getDeptManagerAdd().msgPrint("정보를 모두 입력해주세요.");
					return;
				}
				
				if(!Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", uiMain.getDeptManagerAdd().getJumin())) {
					uiMain.getDeptManagerAdd().msgPrint("유효한 주민등록번호가 아닙니다.");
					return;
				}
			
				if(!model.checkID(uiMain.getDeptManagerAdd().getId())) {
					uiMain.getDeptManagerAdd().msgPrint("이미 존재하는 아이디입니다.");
					return;
				}
				
				if(!model.deptCheck(uiMain.getDeptManagerAdd().getDept())) {
					uiMain.getDeptManagerAdd().msgPrint("존재하지 않는 학과입니다.");
					return;
				}
			
				if(model.compare(uiMain.getDeptManagerAdd().getId())) {
					model.insert(uiMain.getDeptManagerAdd().getId(), uiMain.getDeptManagerAdd().getName(), uiMain.getDeptManagerAdd().getJumin().substring(7), uiMain.getDeptManagerAdd().getDept(), uiMain.getDeptManagerAdd().getJumin());
					uiMain.getDeptManagerAdd().msgPrint("생성 성공!");
					changePanel("REFRASH");
					uiMain.getDeptManagerAdd().dispose();
				}
				else {
					uiMain.getDeptManagerAdd().msgPrint("규칙에 어긋나는 아이디입니다.");
				}
			}
		};
		
		this.cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiMain.getDeptManagerAdd().dispose();
			}
		};
		
	}
	
	@Override
	public void setListener() {
		uiMain.getDeptManagerAdd().getOkButton().addActionListener(ok);
		uiMain.getDeptManagerAdd().getCancelButton().addActionListener(cancel);
	}
}
