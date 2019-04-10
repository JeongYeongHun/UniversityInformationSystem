package mvc.model;

import java.util.Calendar;

public class ProfessorService {
	private ProClassModel proclassmodel;
	private String[][] str;

	
	public ProfessorService(String id) {
		proclassmodel = new ProClassModel(id);
		modelToString();
	}
	
	public void modelToString(){

		str = new String[proclassmodel.getProclassinfo().length][5];
		
		for(int i = 0; i < proclassmodel.getProclassinfo().length; i++) {
			str[i][0] = proclassmodel.getProclassinfo()[i].getClassNo();
			str[i][1] = proclassmodel.getProclassinfo()[i].getClassName();
			str[i][2] = proclassmodel.getProclassinfo()[i].getChargeDept().toString();
			str[i][3] = String.valueOf(proclassmodel.getProclassinfo()[i].getScore());
			str[i][4] = proclassmodel.getProclassinfo()[i].getChargeProf();
		}
	}
	
	public boolean checkClass(String classNum) {
		for(int i=0; i<str.length; i++) {
			if(classNum.equals(str[i][0]))
				return true;
		}
		return false;
	}
	
	public boolean checkDate() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.set(Calendar.YEAR, 2018);
		cal2.set(Calendar.MONTH, Calendar.NOVEMBER);
		cal2.set(Calendar.DAY_OF_MONTH, 24);
		if(cal1.after(cal2))
			return true;
		
		return false;
	}
	

	public String[][] getStr() {
		return str;
	}
	
}

