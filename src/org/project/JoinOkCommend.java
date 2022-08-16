package org.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinOkCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("JoinOkCommend");
		
		int custNo=Integer.parseInt(request.getParameter("custNo"));
		String custName=request.getParameter("custName");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String joinDate=request.getParameter("joinDate");
		String grade=request.getParameter("grade");
		String city=request.getParameter("city");
		
		Dao dao=Dao.getInstance();
		int rs=dao.insertDo(custNo, custName, phone, address, joinDate, grade, city);
		
		String url="";
		if(rs!=1) {
			System.out.println("회원가입 실패");
			url="/index.do";
		} else {
			System.out.println("회원가입 성공");
			url="/memberView.do?custNo="+custNo;
		}
		request.setAttribute("url", url);
	}

}
