<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	padding: 0;
	margin: 0;
	width: 1300px; // 가로 폭 height : 100%; //
	세로폭 overflow: hidden; // 범위를 넘엇을시 넘는 영역 숨김 background-position : 0 0;
	//
	시작위치 background-repeat: no-repeat; // 배경화면 반복 background-attachment :
	fixed; // 배경화면 스크롤시 고정 background-size : cover; // 배경화면 비율유지 position :
	relative; //
	위치지정 overflow-y: auto;
	//
	스크롤
}

.index {
	font-size: 40px;
}

.hr {
	background-color: #A6A6A6
}

.n {
	color: #FF0000;
}

.y {
	color: #47C83E;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<jsp:include page="/WEB-INF/views/auth/inc/menu.jsp"></jsp:include>


			<div style="margin-top: 70px; margin-left: 30px">

				<span class="index">회원 목록</span>
				<hr style="min-width: 800px; height: 2px;" class="hr">

				<a class="btn btn-secondary" style="float: left" href="">신규 회원
					등록</a>
				<div style="float: right">
					<form method="post" action="">
						<select style="height: 40px;">
							<option>==전체==</option>
							<option>정상 대여/반납</option>
							<option>연체자</option>
						</select> <input type="text" placeholder="회원 이름 검색"
							style="width: 300px; height: 40px;">
						<button type="button" id="btn" class="btn btn-secondary">검색</button>
					</form>
				</div>
				<div style="margin-top: 30px">
					<table class="table" style="width: 800px; text-align: center;">
						<thead>
							<tr>
								<th>순번</th>
								<th>이름</th>
								<th>연락처</th>
								<th>활성화여부</th>
								<th>연체여부</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="c" items="${list}">
								<tr>
									<td>${c.ID}</td>
									<td>${c.name }</td>
									<td>${c.phone}</td>
									<td>${c.notes }<c:if test="${c.overdue=='N'}">
											<td class="n">${c.overdue}</td>
										</c:if> <c:if test="${c.overdue=='Y'}">
											<td class="y">${c.overdue}</td>
										</c:if>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div style="width:200px; margin: 0 auto;">
					<table class="table" style="width: 200px; text-align: center;">
						<tr>
						<c:if test="${currentPage!=1}">
						<td><a href="${pageContext.request.contextPath}/auth/CustomerListServlet?currentPage=1"> << </a></td>
						<td><a href="${pageContext.request.contextPath}/auth/CustomerListServlet?currentPage=${currentPage-1}"> < </a></td>
						</c:if>
						
						<c:if test="${currentPage==1 }">
						<td> << </td>
						<td> < </td>
						</c:if>
						
						<c:if test="${currentPage!=lastPage}">
						<td><a href="${pageContext.request.contextPath}/auth/CustomerListServlet?currentPage=${currentPage+1}"> > </a></td>
						<td><a href="${pageContext.request.contextPath}/auth/CustomerListServlet?currentPage=${lastPage}"> >> </a></td>
						</c:if>
						
							<c:if test="${currentPage==lastPage }">
						<td> > </td>
						<td> >> </td>
						</c:if>
					</tr>
					
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>