package org.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListViewCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberListViewCommend");
		
		Dao dao=Dao.getInstance();
		ArrayList<MemberDto> lists=dao.list();
		
		String url="";
		if(lists!=null) {
			System.out.println("회원목록조회 Ok");
			request.setAttribute("lists", lists);
			url="/memberListView.jsp";
		} else {
			System.out.println("회원목록조회 Fail");
			url="/index.do";
		}
		request.setAttribute("url", url);
		
	}

}
