package org.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberMoneyViewCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberMoneyViewCommend");
		
		Dao dao=Dao.getInstance();
		ArrayList<MoneyDto> moneys=dao.money();
		
		String url="";
		if(moneys!=null) {
			System.out.println("회원매출조회 Ok");
			request.setAttribute("moneys", moneys);
			url="/memberMoneyView.jsp";
		} else {
			System.out.println("회원매출조회 Fail");
			url="/index.do";
		}
		request.setAttribute("url", url);
	}

}
