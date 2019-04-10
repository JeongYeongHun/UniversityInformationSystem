package mvc.model;

/**
 * @author 정영훈
 *
 */

public class GetListRollService {
	private ListRollModel model;
	private String[][] str;
	
	public GetListRollService(String classNum) {
		model = new ListRollModel(classNum);
	}
	
	public void lmodelToString(){
		
		str = new String[model.getListRollinfo().length][3];
		
		for(int i = 0; i < model.getListRollinfo().length; i++) {
			str[i][0] = model.getListRollinfo()[i].getNo();
			str[i][1] = model.getListRollinfo()[i].getName();
			str[i][2] = model.getListRollinfo()[i].getChargeDept().toString();
		}
	}
	
	public void rmodelToString(){
		
		str = new String[model.getListRollinfo().length][3];
			
		for(int i = 0; i < model.getListRollinfo().length; i++) {
			str[i][0] = model.getListRollinfo()[i].getNo();
			str[i][1] = model.getListRollinfo()[i].getName();
			str[i][2] = model.getListRollinfo()[i].getScore();
		}
	}
	
	public String[][] getStr(){
		return str;
	}
	
	public ListRollModel getListRollModel() {
		return model;
	}
}
