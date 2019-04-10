package mvc.model;

public class InsertScoreService {
	private GetListRollService lrservice;
	
	public InsertScoreService(String classNum) {
		lrservice = new GetListRollService(classNum);
		lrservice.rmodelToString();
	}

	public boolean checkInsertId(String id) {
		if("".equals(id)) {
			return false;
		}
		return true;
	}
	
	public String checkInsertScore(boolean a, boolean b, boolean c, boolean d, boolean f) {
		if(a) return "A";
		if(b) return "B";
		if(c) return "C";
		if(d) return "D";
		if(f) return "F";
		return "성적을 선택해주세요.";
	}
	
	public String scoreApply(String classNum, String id, String score) {
		lrservice.getListRollModel().insertScore(classNum, id, score);
		
		return "scc";
	}
	
	public boolean checkClass(String id) {
		String[][] info = lrservice.getStr();
		for(int i=0; i<info.length; i++) {
			if(id.equals(info[i][0]))
				return true;
		}
		return false;
	}
	
	public GetListRollService getLRService() {
		return lrservice;
	}
}
