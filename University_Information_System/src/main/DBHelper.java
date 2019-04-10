package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 정영훈
 *
 */
public class DBHelper {
	private static final Logger logger = Logger.getGlobal();
	private String table;	//테이블명
	private String jdbcUrl  = "";		//서버주소
    private String dbId  = "";		//아이디
    private String dbPass = "";	//비밀번호
    private String cfname = "oracle.jdbc.driver.OracleDriver";
	
    
	public DBHelper(String table) {
		this.table = table;
	}
	
	
	//레코드 삽입
	public void insert(String no, String...str) {	//no는 primary key로써 학번, 교수번호 등
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try{
	        int i = 1;
	        
	        Class.forName(cfname);
	        conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);

	        String tsql = "insert into " + table + " values ('" + no + "'";
	        StringBuilder bld = new StringBuilder();
	        bld.append(tsql);
	        
	        for(int k = 0; k < str.length; k++) {		//인자 수만큼 ? 생성
	        	bld.append(",?");
	        }
	        bld.append(")");
	        String sql = bld.toString();
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        for(String s:str) {
	        	pstmt.setString(i, s);
	        	i = i+1;
	        }
	        
	        pstmt.executeUpdate();
	        conn.commit();
	        
	    }catch(Exception e){
	    	logger.info("info Log insert");
	        }finally{
	            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){logger.warning("warning insert pstmt");}
	            if(conn!=null)try{conn.close();}catch(SQLException sqle){logger.warning("warning insert conn");}
	        }
	}
	
	
	//전체 값 받아오기
	public List<String[]> selectAll() {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<String[]> result = new ArrayList<>();
	    
	    
	    try{
	        Class.forName(cfname);
	        conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);

	        String sql = "select * from " + table;
	        pstmt = conn.prepareStatement(sql);     
	        rs = pstmt.executeQuery();
	        
	        ResultSetMetaData md = rs.getMetaData();
	        int col = md.getColumnCount();	//컬럼개수
	        
	        //컬럼명 저장
	        String[] colName = new String[col];
	        for(int i=1; i <= col; i++) {
	        	colName[i-1] = md.getColumnName(i);
	        }
	        result.add(colName);
	        
	        //레코드 저장
	        while(rs.next()) {
	        	String[] record = new String[col];
	        	for(int i = 0; i < col; i++) {
	        		record[i] = rs.getString(colName[i]);
	        	}
	        	result.add(record);
	        }
	        
	        return result;
	    }catch(Exception e){
	    	logger.info("info Log select");
	    }finally{
            if(rs!=null)try{rs.close();}catch(SQLException sqle){logger.warning("warning select rs");}
            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){logger.warning("warning select pstmt");}
            if(conn!=null)try{conn.close();}catch(SQLException sqle){logger.warning("warning select conn");}
        }
	    return result;
	}
	
	
	//조건 검색
	public List<String[]> search(String target, String column, String value) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<String[]> result = new ArrayList<>();
	    
	    try{
	        Class.forName(cfname);
	        conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);

	        String sql = "select " + target + " from " + table + " where " + column + "=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, value);
	        rs = pstmt.executeQuery();
	        
	        ResultSetMetaData md = rs.getMetaData();
	        int col = md.getColumnCount();	//컬럼개수
	        
	        //컬럼명 저장
	        String[] colName = new String[col];
	        for(int i=1; i <= col; i++) {
	        	colName[i-1] = md.getColumnName(i);
	        }
	        result.add(colName);
	        
	        //레코드 저장
	        while(rs.next()) {
	        	String[] record = new String[col];
	        	for(int i = 0; i < col; i++) {
	        		record[i] = rs.getString(colName[i]);
	        	}
	        	result.add(record);
	        }
	        
	        return result;
	    }catch(Exception e){
	    	logger.info("info Log search");
	        }finally{
	            if(rs!=null)try{rs.close();}catch(SQLException sqle){logger.warning("warning search rs");}
	            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){logger.warning("warning search pstmt");}
	            if(conn!=null)try{conn.close();}catch(SQLException sqle){logger.warning("warning search conn");}
	        }
	    return result;
	}
	
	
	//레코드 삭제
	public void delete(String column, String value) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try{
	        Class.forName(cfname);
	        conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);

	        String sql = "delete from " + table + " where " + column + "=?";
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, value);
	        pstmt.executeUpdate();
	        conn.commit();
	    }catch(Exception e){
	    	logger.info("info Log delete");
	        }finally{
	            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){logger.warning("warning delete pstmt");}
	            if(conn!=null)try{conn.close();}catch(SQLException sqle){logger.warning("warning delete conn");}
	        }
	}
	
	
	//정보 수정
	public boolean update(String wColumn, String wValue, String column, String value) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    try{
	        Class.forName(cfname);
	        conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);

	        String sql = "update " + table + " set " + column + "=? where " + wColumn + "=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, value);
	        pstmt.setString(2, wValue);
	        pstmt.executeUpdate();
	        conn.commit();
	        return true;
	        
	    }catch(Exception e){
	    	logger.info("info Log update");
	    	return false;
	        }finally{
	            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){logger.warning("warning update pstmt");}
	            if(conn!=null)try{conn.close();}catch(SQLException sqle){logger.warning("warning update conn");}
	        }
	}
	

	//getter
	public String getTable() {
		return table;
	}
}
