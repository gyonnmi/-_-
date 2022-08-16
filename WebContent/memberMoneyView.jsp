<%@page import="java.util.ArrayList"%>
<%@page import="org.project.MoneyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MoneyDto> moneys =
		(ArrayList<MoneyDto>)request.getAttribute("moneys");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MoneyView</title>
<link rel="stylesheet" href="css/memberMoneyView.css" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<table>
				<thead>
					<tr>
						<th colspan="4" class="t1">회원매출조회</th>
					</tr>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>고객등급</th>
						<th>매출</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (MoneyDto list:moneys) {
					%>		
					<tr>
						<td><%=list.getCustNo() %></td>
						<td><%=list.getCustName() %></td>
						<td><%=list.getGrade() %></td>
						<td><%=list.getPrice() %></td>
					<%		
						}
					%>
					</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>