<%@page import="org.project.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Dao dao=Dao.getInstance();
	int custNo=dao.maxNo();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" href="css/join.css" />
<script src="js/joinOk.js" defer></script>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<form action="joinOk.do" method="post" id="joinForm" >
				<table>
					<thead>
						<tr>
							<th colspan="2">홈쇼핑 회원 등록</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="custNo">회원번호(자동발생)</label></td>
							<td><input type="hidden" name="custNo" id="custNo" value="<%=custNo %>" />
									<span><%=custNo %></span>
							</td>
						</tr>
						<tr>
							<td><label for="custName">회원성명</label></td>
							<td><input type="text" name="custName" id="custName" /></td>
						</tr>
						<tr>
							<td><label for="phone">회원전화</label></td>
							<td><input type="text" name="phone" id="phone" /></td>
						</tr>
						<tr>
							<td><label for="address">회원주소</label></td>
							<td><input type="text" name="address" id="address" /></td>
						</tr>
						<tr>
							<td><label for="joinDate">가입일자</label></td>
							<td><input type="text" name="joinDate" id="joinDate" /></td>
						</tr>
						<tr>
							<td><label for="grade">고객등급[A:VIP,B:일반,C:직원]</label></td>
							<td>
								<select name="grade" id="grade">
									<option value="">::선택::</option>
									<option value="A">VIP</option>
									<option value="B">일반</option>
									<option value="C">직원</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="city">도시코드</label></td>
							<td>
								<select name="city" id="city">
									<option value="">::선택::</option>
									<option value="01">서울</option>
									<option value="30">울릉도</option>
									<option value="60">제주도</option>
								</select>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2">
								<input type="button" value="등록" id="joinOkBtn" class="td_last" />
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