package org.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberViewCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberViewCommend");
		
		int custNo=Integer.parseInt(request.getParameter("custNo"));
		
		Dao dao=Dao.getInstance();
		MemberDto member=dao.memberView(custNo);
		
		String url="";
		if(member!=null) {
			System.out.println("회원상세조회 Ok");
			request.setAttribute("member", member);
			url="/memberView.jsp";
		} else {
			System.out.println("회원상세조회 Fail");
			url="/index.do";
		}
		request.setAttribute("url", url);
	}

}
