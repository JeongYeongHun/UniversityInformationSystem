package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import mvc.model.ModifyPasswordService;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class ModifyPasswordHandler implements BaseController{
	
	private MainFrame uiMain;
	private ModifyPasswordService user;
	private ActionListener ok;
	private ActionListener cancel;
	
	public ModifyPasswordHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		user = new ModifyPasswordService(uiMain.getLoginPanel().getLogin_id());
		setEvent();
		setListener();
	}
	
	
	public boolean modifyPassword(String newPassword, String checkPassword) {
		if(newPassword.equals(checkPassword)) {
			return user.update(newPassword);
		}
		return false;
	}


	@Override
	public void changePanel(String type) {
		//구현 미필요
	}


	@Override
	public void setEvent() {
		ok = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(String.valueOf(uiMain.getmPwPanel().getNewPassword().getPassword()))) {
					uiMain.getmPwPanel().msgPrint("새로운 비밀번호를 입력해주세요.");
					return;
				}
				
				if(!Pattern.matches("^[a-zA-Z0-9]{7}$", String.valueOf(uiMain.getmPwPanel().getNewPassword().getPassword()))) {
					uiMain.getmPwPanel().msgPrint("변경 실패!\n영문자 및 숫자 조합 7자리가 아닙니다.");
					return;
				}
				
				if(!modifyPassword(String.valueOf(uiMain.getmPwPanel().getNewPassword().getPassword()), String.valueOf(uiMain.getmPwPanel().getCheckPassword().getPassword()))) {
					uiMain.getmPwPanel().msgPrint("변경 실패!\n두 값이 서로 다릅니다.");
					return;
				}
				
				uiMain.getmPwPanel().msgPrint("변경성공!!");
				uiMain.getmPwPanel().dispose();
			}
		};
		
		cancel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiMain.getmPwPanel().dispose();
			}
		};
	}


	@Override
	public void setListener() {
		uiMain.getmPwPanel().getOkButton().addActionListener(ok);
		uiMain.getmPwPanel().getCancelButton().addActionListener(cancel);
	}
}
