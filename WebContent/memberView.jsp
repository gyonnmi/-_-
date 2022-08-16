<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.project.MemberDto"%>
<%@page import="org.project.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDto member=(MemberDto)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" href="css/join.css" />
<script src="js/updateOk.js" defer></script>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<form action="updateOk.do" method="post" id="updateForm" >
				<table>
					<thead>
						<tr>
							<th colspan="2">홈쇼핑 회원 정보수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="custNo">회원번호(자동발생)</label></td>
							<td><input type="hidden" name="custNo" id="custNo" value="<%=member.getCustNo() %>" />
									<span><%=member.getCustNo() %></span>
							</td>
						</tr>
						<tr>
							<td><label for="custName">회원성명</label></td>
							<td><input type="text" name="custName" id="custName" value="<%=member.getCustName() %>" /></td>
						</tr>
						<tr>
							<td><label for="phone">회원전화</label></td>
							<td><input type="text" name="phone" id="phone" value="<%=member.getPhone() %>" /></td>
						</tr>
						<tr>
							<td><label for="address">회원주소</label></td>
							<td><input type="text" name="address" id="address" value="<%=member.getAddress() %>"/></td>
						</tr>
						<tr>
							<%
								Date day1=member.getJoinDate();
								SimpleDateFormat simp=new SimpleDateFormat("YYYYMMDD");
								String day2=simp.format(day1);
							%>
							<td><label for="joinDate">가입일자</label></td>
							<td><input type="text" name="joinDate" id="joinDate" value="<%=member.getJoinDate() %>" /></td>
						</tr>
						<tr>
							<td><label for="grade">고객등급[A:VIP,B:일반,C:직원]</label></td>
							<td>
								<select name="grade" id="grade" >
									<option value="" <%if(member.getGrade().equals("")){%>selected<%} %>>::선택::</option>
									<option value="A" <%if(member.getGrade().equals("A")){%>selected<%} %>>VIP</option>
									<option value="B" <%if(member.getGrade().equals("B")){%>selected<%} %>>일반</option>
									<option value="C" <%if(member.getGrade().equals("C")){%>selected<%} %>>직원</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="city">도시코드</label></td>
							<td>
								<select name="city" id="city">
									<option value="" <%if(member.getCity().equals("")){%>selected<%} %>>::선택::</option>								
									<option value="01" <%if(member.getCity().equals("01")){%>selected<%} %>>서울</option>								
									<option value="30" <%if(member.getCity().equals("30")){%>selected<%} %>>울릉도</option>								
									<option value="60" <%if(member.getCity().equals("60")){%>selected<%} %>>제주도</option>								
								</select>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2">
								<input type="button" value="수정" id="updateOkBtn" class="td_last" />
								<a href="memberListView.do" class="td_last">조회</a>
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>