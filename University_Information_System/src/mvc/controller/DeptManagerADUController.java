package mvc.controller;

import java.awt.event.ActionListener;

import mvc.model.ProfessorModel;
import mvc.model.StudentModel;
import mvc.model.User;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public abstract class DeptManagerADUController implements BaseController{
	protected MainFrame uiMain;
	protected ActionListener ok;
	protected ActionListener cancel;
	protected User model;
	protected int conType;
	
	public void checkModel() {
		if(uiMain.getContentPane() == uiMain.getDeptManagerStudentSelectPanel()) {
			model = new StudentModel();
			conType = 0;
		}
		if(uiMain.getContentPane() == uiMain.getDeptManagerProfessorSelectPanel()) {
			model = new ProfessorModel();
			conType = 1;
		}
	}
	
	@Override
	public void changePanel(String type) {
		if("REFRASH".equals(type)) {
			if(conType == 0) {
				uiMain.setDeptManagerStudentSelectPanel();
			}
			if(conType == 1) {
				uiMain.setDeptManagerProfessorSelectPanel();
			}
			new DeptManagerSelectHandler(uiMain);
		}
		uiMain.revalidate();
	}
}
