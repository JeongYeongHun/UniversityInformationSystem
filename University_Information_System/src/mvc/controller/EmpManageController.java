package mvc.controller;

import java.awt.event.ActionListener;

import mvc.model.MasterModel;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public abstract class EmpManageController implements BaseController{
	protected MainFrame uiMain;
	protected ActionListener ok;
	protected ActionListener cancel;
	protected MasterModel model;
	
	@Override
	public void changePanel(String type) {
		if("REFRASH".equals(type)) {
			uiMain.setMasterPanel();
			new MasterHandler(uiMain);
		}
		uiMain.revalidate();
	}

}
