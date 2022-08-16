package org.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOkCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UpdateOkCommend");
		
		int custNo=Integer.parseInt(request.getParameter("custNo"));
		String custName=request.getParameter("custName");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String joinDate=request.getParameter("joinDate");
		String grade=request.getParameter("grade");
		String city=request.getParameter("city");
		
		Dao dao=Dao.getInstance();
		int rs=dao.updateDo(custNo, custName, phone, address, joinDate, grade, city);
		
		String url="";
		if(rs!=1) {
			System.out.println("회원정보수정 Fail");
			url="/index.do";
		} else {
			System.out.println("회원정보수정 Ok");
			url="/memberListView.do";
		}
		request.setAttribute("url", url);
	}

}
