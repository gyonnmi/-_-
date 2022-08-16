package org.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path=request.getContextPath();
		String uri=request.getRequestURI();
		String basicURL=uri.substring(path.length());
		
		System.out.println(basicURL);
		
		ExcuteCommend commend=null;
		
		String url="";
		if(basicURL.equals("/index.do")) {
			url="/index.jsp";
		} else if(basicURL.equals("/joinView.do")) {
			url="/joinView.jsp";
		} else if(basicURL.equals("/joinOk.do")) {
			commend=new JoinOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/memberView.do")) {
			commend=new MemberViewCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/memberListView.do")) {
			commend=new MemberListViewCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/updateOk.do")) {
			commend=new UpdateOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/memberMoneyView.do")) {
			commend=new MemberMoneyViewCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		}
		
		RequestDispatcher disp=request.getRequestDispatcher(url);
		disp.forward(request, response);
		
	}

}
