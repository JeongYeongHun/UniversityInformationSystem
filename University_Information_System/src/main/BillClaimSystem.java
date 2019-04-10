package main;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author 정영훈
 *
 */

public class BillClaimSystem {
	
	private DBHelper db;
	private List<String[]> list;
	private String no;
	private String name;
	private String dept;
	private String[][] classInfo;
	private int pay = 0;
	
	public BillClaimSystem(String studNo) {
		//학생정보와 수강정보, 강의정보를 조인
		db = new DBHelper("(STUDENT_INFO s join REGISTER_INFO r on (s.no = r.stud_no)) join CLASS_INFO using (class_no)");
		list = db.search("no, name, deptname, class_no, class_name", "no", studNo);
		
		classInfo = new String[list.size()-1][2];
		
		String[] record = list.get(1);
		
		no = record[0];
		name = record[1];
		dept = record[2];
		
		for(int i = 0; i < list.size()-1; i++) {
			String[] result = list.get(i+1);
			classInfo[i][0] = result[3];
			classInfo[i][1] = result[4];
			pay = pay + 500;
		}
		
		System.out.println("----------수강료 청구서----------");
		System.out.println("학번 : " + no +"");
		System.out.println("이름 : " + name+"");
		System.out.println("학과 : " + dept+"");
		System.out.println("수강과목 : ");
		for(int i = 0; i < list.size()-1; i++) {
			System.out.println("  " + classInfo[i][0] + "  " + classInfo[i][1] + "");
		}
		System.out.println("수강료 : $" + pay);
		System.out.println("------------------------------");
		
	}

}
