package mvc.view;

import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 * @author 정영훈
 *
 */

public class MainFrame extends JFrame {

	private ModifyPasswordDialog mPwPanel;
	private LoginPanel loginPanel;
	private StudentPanel studentPanel;
	private ProfessorPanel professorPanel;
	private GetList getlist;
	private GetRoll getroll;
	private InsertScore insertscore;
	private ClassApplyPanel classApplyPanel;
	private CheckScorePanel checkScorePanel;
	private MasterPanel masterPanel;
	private EmpDialog modifyEmp;
	private DeleteEmpDialog deleteEmp;
	private ClassManagerPanel classManagerPanel;
	private ClassManagerUpdateDialog classManagerUpdate;
	private ClassManagerDeleteDialog classManagerDelete;
	private ClassManagerOpenDialog classManagerOpen;
	private DeptManagerPanel deptManagerPanel;
	private DeptManagerStudentSelectPanel deptManagerStudentSelectPanel;
	private DeptManagerProfessorSelectPanel deptManagerProfessorSelectPanel;
	private DeptManagerAddDialog deptManagerAdd;
	private DeptManagerUpdateDialog deptManagerUpdate;
	private BillSendPanel billSendPanel;

	public MainFrame(LoginPanel loginPanel) {	//최초는 로그인 화면
		this.loginPanel = loginPanel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(this.loginPanel);
	}
	
	public void setLoginPanel() {
		loginPanel = new LoginPanel();
		setBounds(100, 100, 450, 300);
		setContentPane(loginPanel);
	}
	
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}
	
	public void setStudentPanel() {
		studentPanel = new StudentPanel(loginPanel.getLogin_id());
		setBounds(100, 100, 430, 200);
		setContentPane(studentPanel);
	}

	public StudentPanel getStudentPanel() {
		return studentPanel;
	}
	public void setProfessorPanel() {
		professorPanel = new ProfessorPanel(loginPanel.getLogin_id());
		setBounds(100, 100, 470, 500);
		setContentPane(professorPanel);
	}


	public ProfessorPanel getProfessorPanel() {
		return professorPanel;
	}
	
	public void setGetList() {
		getlist = new GetList(professorPanel.getclass_num());
		setBounds(100, 100, 600, 600);
		setContentPane(getlist);
	}

	public GetList getGetList() {
		return getlist;
	}
	
	public void setGetRoll() {
		getroll = new GetRoll(professorPanel.getclass_num());
		setBounds(100, 100, 600, 600);
		setContentPane(getroll);
	}

	public GetRoll getGetRoll() {
		return getroll;
	}
	
	public void setInsertScore() {
		insertscore = new InsertScore(professorPanel.getclass_num());
		setBounds(100, 100, 600, 700);
		setContentPane(insertscore);
	}

	public InsertScore getInsertScore() {
		return insertscore;
	}
	
	public void setClassApplyPanel() {
		classApplyPanel = new ClassApplyPanel(loginPanel.getLogin_id());
		
		setBounds(100, 100, 820, 650);
		setContentPane(classApplyPanel);
	}
	
	public ClassApplyPanel getClassApplyPanel() {
		return classApplyPanel;
	}
	
	public void setCheckScorePanel() {
		checkScorePanel = new CheckScorePanel(loginPanel.getLogin_id());
		setBounds(100, 100, 820, 600);
		setContentPane(checkScorePanel);
	}
	
	public CheckScorePanel getCheckScorePanel() {
		return checkScorePanel;
	}

	public MasterPanel getMasterPanel() {
		return masterPanel;
	}

	public void setMasterPanel() {
		masterPanel = new MasterPanel();
		setBounds(100, 100, 470, 350);
		setContentPane(masterPanel);
	}

	public ModifyPasswordDialog getmPwPanel() {
		return mPwPanel;
	}

	public void setmPwPanel() {
		mPwPanel = new ModifyPasswordDialog();
		mPwPanel.setVisible(true);
	}

	public EmpDialog getModifyEmp() {
		return modifyEmp;
	}

	public void setModifyEmp() {
		modifyEmp = new EmpDialog();
		modifyEmp.setVisible(true);
	}
	
	public DeleteEmpDialog getDeleteEmp() {
		return deleteEmp;
	}

	public void setDeleteEmp() {
		deleteEmp = new DeleteEmpDialog();
		deleteEmp.setVisible(true);
	}

	public ClassManagerPanel getClassManagerPanel() {
		return classManagerPanel;
	}

	public void setClassManagerPanel() {
		classManagerPanel = new ClassManagerPanel(loginPanel.getLogin_id());
		setBounds(100, 100, 820, 650);
		setContentPane(classManagerPanel);
	}

	public ClassManagerUpdateDialog getClassManagerUpdate() {
		return classManagerUpdate;
	}
	
	public void setClassManagerUpdate() {
		classManagerUpdate = new ClassManagerUpdateDialog();
		classManagerUpdate.setVisible(true);
	}
	
	public ClassManagerDeleteDialog getClassManagerDelete() {
		return classManagerDelete;
	}
	
	public void setClassManagerDelete() {
		classManagerDelete = new ClassManagerDeleteDialog();
		classManagerDelete.setVisible(true);
	}
	
	public ClassManagerOpenDialog getClassManagerOpen() {
		return classManagerOpen;
	}
	
	public void setClassManagerOpen() {
		classManagerOpen = new ClassManagerOpenDialog();
		classManagerOpen.setVisible(true);
	}

	public DeptManagerPanel getDeptManagerPanel() {
		return deptManagerPanel;
	}

	public void setDeptManagerPanel() {
		deptManagerPanel = new DeptManagerPanel(loginPanel.getLogin_id());
		setBounds(100, 100, 430, 300);
		setContentPane(deptManagerPanel);
	}

	public DeptManagerStudentSelectPanel getDeptManagerStudentSelectPanel() {
		return deptManagerStudentSelectPanel;
	}

	public void setDeptManagerStudentSelectPanel() {
		deptManagerStudentSelectPanel = new DeptManagerStudentSelectPanel(loginPanel.getLogin_id());
		setBounds(100, 100, 820, 650);
		setContentPane(deptManagerStudentSelectPanel);
	}
	
	public DeptManagerProfessorSelectPanel getDeptManagerProfessorSelectPanel() {
		return deptManagerProfessorSelectPanel;
	}

	public void setDeptManagerProfessorSelectPanel() {
		deptManagerProfessorSelectPanel = new DeptManagerProfessorSelectPanel(loginPanel.getLogin_id());
		setBounds(100, 100, 820, 650);
		setContentPane(deptManagerProfessorSelectPanel);
	}

	public DeptManagerAddDialog getDeptManagerAdd() {
		return deptManagerAdd;
	}
	
	public void setDeptManagerAdd() {
		deptManagerAdd = new DeptManagerAddDialog();
		deptManagerAdd.setVisible(true);
	}

	public DeptManagerUpdateDialog getDeptManagerUpdate() {
		return deptManagerUpdate;
	}
	
	public void setDeptManagerUpdate() {
		deptManagerUpdate = new DeptManagerUpdateDialog();
		deptManagerUpdate.setVisible(true);
	}

	public BillSendPanel getBillSendPanel() {
		return billSendPanel;
	}

	public void setBillSendPanel() {
		billSendPanel = new BillSendPanel();
		setBounds(100, 100, 450, 340);
		setContentPane(billSendPanel);
	}
	
	
}
