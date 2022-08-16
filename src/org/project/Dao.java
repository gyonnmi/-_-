package org.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class Dao {
	private static class singleton {
		private static final Dao INSTANCE = new Dao();
	}
	
	private Dao() {}
	
	public static Dao getInstance() {
		return singleton.INSTANCE;
	}
	
	
	//회원번호 마지막번호+1
	public int maxNo() {
		int maxNo=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnetion();
			query="select max(custNo)+1 from member_tbl_03";
			pstm=conn.prepareStatement(query);
			rs=pstm.executeQuery();
			if(rs.next()) {
				maxNo=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}
	
	
	//회원가입
	public int insertDo(int custNo, String custName, String phone, String address, 
			String joinDate, String grade, String city) {
		int rs=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		try {
			conn=DBConnect.getConnetion();
			query="insert into member_tbl_03 values (?,?,?,?,?,?,?)";
			pstm=conn.prepareStatement(query);
			pstm.setInt(1, custNo);
			pstm.setString(2, custName);
			pstm.setString(3, phone);
			pstm.setString(4, address);
			pstm.setString(5, joinDate);
			pstm.setString(6, grade);
			pstm.setString(7, city);
			rs=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	
	//회원상세조회
	public MemberDto memberView(int custNo) {
		MemberDto member=null;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnetion();
			query="select * from member_tbl_03 where custNo=?";
			pstm=conn.prepareStatement(query);
			pstm.setInt(1, custNo);

			rs=pstm.executeQuery();
			if(rs.next()) {
				int custNo2=rs.getInt(1);
				String custName=rs.getString(2);
				String phone=rs.getString(3);
				String address=rs.getString(4);
				Date joinDate=rs.getDate(5);
				String grade=rs.getString(6);
				String city=rs.getString(7);
				
				member=new MemberDto(custNo2, custName, phone, address, joinDate, grade, city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return member;
	}
	
	
	//회원목록조회
	public ArrayList<MemberDto> list() {
		ArrayList<MemberDto> lists=new ArrayList<MemberDto>();
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnetion();
			query="select * from member_tbl_03";
			pstm=conn.prepareStatement(query);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int custNo=rs.getInt(1);
				String custName=rs.getString(2);
				String phone=rs.getString(3);
				String address=rs.getString(4);
				Date joinDate=rs.getDate(5);
				String grade=rs.getString(6);
				String city=rs.getString(7);
				
				lists.add(new MemberDto(custNo, custName, phone, address, joinDate, grade, city));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lists;
	}
	
	
	//회원매출조회
	public ArrayList<MoneyDto> money() {
		ArrayList<MoneyDto> moneys=new ArrayList<MoneyDto>();
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnetion();
			query="select m1.custNo, m1.custName, m1.grade, sum(m2.price) as total "
					+ "from member_tbl_03 m1 join money_tbl_03 m2 on m1.custNo = m2.custNo "
					+ "group by (m1.custNo, m1.custName, m1.grade) order by total desc";
			pstm=conn.prepareStatement(query);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int custNo=rs.getInt(1);
				String custName=rs.getString(2);
				String grade=rs.getString(3);
				int price=rs.getInt(4);
				
				moneys.add(new MoneyDto(custNo, custName, grade, price));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return moneys;
	}
	
	
	//회원정보수정
	public int updateDo(int custNo, String custName, String phone, String address, 
			String joinDate, String grade, String city) {
		int rs=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		try {
			conn=DBConnect.getConnetion();
			query="update member_tbl_03 set custName=?, phone=?, "
					+ "address=?, joinDate=?, grade=?, city=? "
					+ "where custno=?"; 
			pstm=conn.prepareStatement(query);
			pstm.setString(1, custName);
			pstm.setString(2, phone);
			pstm.setString(3, address);
			pstm.setString(4, joinDate);
			pstm.setString(5, grade);
			pstm.setString(6, city);
			pstm.setInt(7, custNo);
			
			rs=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	
	
}
