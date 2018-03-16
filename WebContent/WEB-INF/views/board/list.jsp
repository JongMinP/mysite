<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>


				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(boards) }" /> 
					<c:forEach items="${boards }" var="board" varStatus="status">
						<tr>
							<td>${count - status.index}</td>
							<td><a href="/mysite/board?a=detail&no=${board.no }">${board.title}</a></td>
							<td>${board.user.name }</td>
							<td>${board.count }</td>
							<td>${board.regDate }</td>
							<td>
								<c:if test="${board.user.no eq authUser.no }">
									<a href="/mysite/board?a=delete&no=${board.no }" class="del">삭제</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>


<!-- 					<tr> -->
<!-- 						<td>2</td> -->
<!-- 												20*vo.depth -->
<%-- 						<td style="text-align:left; padding-left:${20*1}px"><img --%>
<!-- 							src="/mysite/assets/images/reply.png" /> <a href="">두 번째 -->
<!-- 								글입니다.</a></td> -->
<!-- 						<td>안대혁</td> -->
<!-- 						<td>3</td> -->
<!-- 						<td>2015-10-02 12:04:12</td> -->
<!-- 						<td><a href="" class="del">삭제</a></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>1</td> -->
<!-- 						<td><a href="">첫 번째 글입니다.</a></td> -->
<!-- 						<td>안대혁</td> -->
<!-- 						<td>3</td> -->
<!-- 						<td>2015-09-25 07:24:32</td> -->
<!-- 						<td><a href="" class="del">삭제</a></td> -->
<!-- 					</tr> -->
				</table>
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li class="selected">3</li>
						<li><a href="">4</a></li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<div class="bottom">
					<c:if test="${not empty authUser }">
						<a href="/mysite/board?a=insertForm" id="new-book">글쓰기</a>
					</c:if>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>