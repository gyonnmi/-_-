<%@page import="org.project.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberDto> lists=(ArrayList<MemberDto>)request.getAttribute("lists");
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<link rel="stylesheet" href="css/memberListView.css" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<table>
				<thead>
					<tr>
						<th colspan="7" class="t1">회원목록조회/수정</th>
					</tr>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>가입일자</th>
						<th>고객등급</th>
						<th>거주지역</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (MemberDto list:lists) {
					%>		
					<tr>
						<td><a href="memberView.do?custNo=<%=list.getCustNo() %>"><%=list.getCustNo() %></a></td>
						<td><%=list.getCustName() %></td>
						<td><%=list.getPhone() %></td>
						<td><%=list.getAddress() %></td>
						<td><%=list.getJoinDate() %></td>
						<td><%=list.getGrade() %></td>
						<td><%=list.getCity() %></td>
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