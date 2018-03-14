<%@page import="com.cafe24.mysite.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>

<%
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/guestbook" method="post">
					<input type="hidden" name="a" value="insert">
					
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					
					</table>
				</form>
				<ul>
					<li>
						<table>
						<%	int size = list.size();
							int count = 0;
							for (GuestBookVo vo : list) { %>
							<tr>
								<td>[<%=size -= count++ %>]</td>
								<td><%= vo.getName() %></td>
								<td><%=vo.getDateTime() %></td>
								<td><a href="/mysite/guestbook?a=deleteform&no=<%=vo.getNo() %>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>
								<%=(vo.getContent()).replace("\r\n", "<br>") %>	
								</td>
							</tr>
							<% } %>
						</table>
						<br>
					</li>
				</ul>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>