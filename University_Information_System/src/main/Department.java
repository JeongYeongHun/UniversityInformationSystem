package main;

/**
 * @author 정영훈
 *
 */

public enum Department {
	전산학과, 전자공학과, 화학공학과, 기계공학과, 항공우주공학과;
	
	@Override
	public String toString() {
	    switch(this) {
	      case 전산학과: return "전산학과";
	      case 전자공학과: return "전자공학과";
	      case 화학공학과: return "화학공학과";
	      case 기계공학과: return "기계공학과";
	      case 항공우주공학과: return "항공우주공학과";
	      default:       return "non";
	    }
	}
	
}
