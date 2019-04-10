package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mvc.model.ClassApplyService;
import mvc.view.MainFrame;


/**
 * @author 정영훈
 *
 */

public class ClassApplyHandler implements BaseController{

	private MainFrame uiMain;
	private ClassApplyService classApplyService;
	private MouseListener scroll;
	private ActionListener update;
	private ActionListener logout;
	private ActionListener back;
	private ActionListener apply;
	private String[] strinfo;
	
	public ClassApplyHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		classApplyService = new ClassApplyService();
		this.uiMain.getClassApplyPanel().setTable(getClassApplyService());
		strinfo = getClassApplyInfoService();
		setEvent();
		setListener();
	}

	@Override
	public void changePanel(String type) {
		switch(type) {
		case "LOGOUT":
			uiMain.setLoginPanel();
			new LoginHandler(uiMain);
			break;	
		case "CLASSAPPLY":
			int check = classApplyService.insertClassApply(uiMain.getClassApplyPanel().getLogin_id(), uiMain.getClassApplyPanel().getClassNo());
			switch(check) {
			case 0:
				uiMain.getClassApplyPanel().msgPrint("신청 성공.");
				break;
			case 1:
				uiMain.getClassApplyPanel().msgPrint("해당 강의가 없습니다.");
				break;
			case 2:
				uiMain.getClassApplyPanel().msgPrint("신청 실패\n다음 사유로 신청에 실패했습니다.\n- 이미 신청한 강의(중복수강)");
				break;
			case 3:
				uiMain.getClassApplyPanel().msgPrint("신청 실패\n다음 사유로 신청에 실패했습니다.\n- 18학점을 초과하여 신청");
				break;
			case 4:
				uiMain.getClassApplyPanel().msgPrint("신청 실패\n다음 사유로 신청에 실패했습니다.\n- 최대 신청 가능 인원 초과");
				break;
			default:
				break;
			}
			uiMain.setClassApplyPanel();
			new ClassApplyHandler(uiMain);
			break;
		case "BACK":
			uiMain.setStudentPanel();
			new StudentHandler(uiMain);
			break;
		case "CHANGEPW":
			uiMain.setmPwPanel();
			new ModifyPasswordHandler(uiMain);
			break;
		default:
			break;
		}
		uiMain.revalidate();
	}
	
	public String[][] getClassApplyService() {
		return classApplyService.getStr();
	}
	
	public String[] getClassApplyInfoService() {
		return classApplyService.getStrinfo();
	}

	@Override
	public void setEvent() {

		scroll = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uiMain.getClassApplyPanel().msgPrint(strinfo[uiMain.getClassApplyPanel().getSelected()]);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				//미필요 기능
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//미필요 기능
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//미필요 기능
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				//미필요 기능
			}
			
		};
		
		update = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CHANGEPW");
			}
		};
		
		logout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("LOGOUT");
			}
		};
		
		apply = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("CLASSAPPLY");
			}
		};
		
		back = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("BACK");
			}
		};
		
	}

	@Override
	public void setListener() {
		uiMain.getClassApplyPanel().getScrollPane().getViewport().getView().addMouseListener(scroll);
		uiMain.getClassApplyPanel().getBtnApply().addActionListener(apply);
		uiMain.getClassApplyPanel().getBtnBack().addActionListener(back);
		uiMain.getClassApplyPanel().getBtnLogOut().addActionListener(logout);
		uiMain.getClassApplyPanel().getBtnUpdate().addActionListener(update);
	}
	
}
