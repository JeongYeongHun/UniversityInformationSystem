package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.BillClaimSystem;
import mvc.model.BillSendModel;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class BillSendHandler implements BaseController{
	
	private MainFrame uiMain;
	private ActionListener logout;
	private ActionListener bill;
	private ActionListener back;
	private BillSendModel model;

	public BillSendHandler(MainFrame uiMain) {
		this.uiMain = uiMain;
		model = new BillSendModel();
		
		uiMain.getBillSendPanel().setTable(model.getInfo());
		
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
			case "BACK":
				uiMain.setClassManagerPanel();
				new ClassManagerHandler(uiMain);
				break;
			case "BILL":
				if("".equals(uiMain.getBillSendPanel().getStudNo())) {
					uiMain.getBillSendPanel().msgPrint("값을 입력해주세요");
					break;
				}
				if(model.checkStud(uiMain.getBillSendPanel().getStudNo())) {
					new BillClaimSystem(uiMain.getBillSendPanel().getStudNo());
					uiMain.getBillSendPanel().msgPrint("수강료 청구서 발급 완료!");
					break;
				}
				else {
					uiMain.getBillSendPanel().msgPrint("해당 학생은 수강신청을 하지 않았습니다.");
				}
				break;
			default:
				break;
		}
		uiMain.revalidate();
		
	}

	@Override
	public void setEvent() {
		logout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("LOGOUT");
			}
		};
		
		bill = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel("BILL");
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
		uiMain.getBillSendPanel().getBtnBack().addActionListener(back);
		uiMain.getBillSendPanel().getBtnBill().addActionListener(bill);
		uiMain.getBillSendPanel().getBtnLogOut().addActionListener(logout);
	}

}
