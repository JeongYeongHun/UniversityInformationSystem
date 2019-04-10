package mvc.controller;

import java.awt.event.ActionListener;

import mvc.model.ClassManageService;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public abstract class ClassManagerAUDOController implements BaseController{
	protected MainFrame uiMain;
	protected ActionListener ok;
	protected ActionListener cancel;
	protected ClassManageService classManageService;
	
	public ClassManagerAUDOController(MainFrame uiMain) {
		this.uiMain = uiMain;
		classManageService = new ClassManageService();
	}
	
	@Override
	public void changePanel(String type) {
		if("REFRASH".equals(type)) {
			uiMain.setClassManagerPanel();
			new ClassManagerHandler(uiMain);
		}
		uiMain.revalidate();
	}
}
