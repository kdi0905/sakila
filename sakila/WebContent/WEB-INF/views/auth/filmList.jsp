<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
              padding:0;
              margin:0;

              width: 1300px;
              height: 100%;
              overflow: hidden; 
              background-position: 0 0; 
              background-repeat: no-repeat; 
              background-attachment: fixed; 
              background-size: cover; 
              position: relative;
              overflow-y: auto; 
          }

.index {
	font-size: 40px;
}

.hr {
	background-color: #A6A6A6
}

</style>
	
</head>
<body>
		<div class="container-fluid">
		<div class="row">
			
				<jsp:include page="/WEB-INF/views/auth/inc/menu.jsp"></jsp:include>
			

			<div style=" margin-top: 70px; margin-left: 30px">
					
					<span class="index">영화 목록</span>
					<hr style="min-width:800px; height: 2px;" class="hr">
					
					<a class ="btn btn-secondary" style="float: left"href="">영화 정보 등록</a>
					<div style="float: right">
					<form method="post" action="">
						<select style="height: 40px;">
							<option>==전체==</option>
							<option>정상 대여/반납</option>
							<option>연체자</option>
						</select>
					<input type="text" placeholder="영화 이름 검색" style="width:300px; height:40px;">
					<button type="button" id="btn" class="btn btn-secondary" >검색</button>
					</form>
					</div>
					
					<div style="margin-top: 40px">
					<table class="table" style="width: 800px; text-align: center;">
						<thead>
							<tr>
								<th>카테고리</th>
								<th>영화제목</th>
								<th>언어</th>
								<th>시청등급</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody >
								<c:forEach var="fl" items="${filmList}">
									<tr>
										<td>${fl.category }</td>
										<td>${fl.title }</td>
										<td>${fl.language}</td>
										<td>${fl.rating }</td>
										<td>${fl.price }</td>
									</tr>
								</c:forEach>
					 </tbody>
					</table>
					</div>
				<div>
					<table class="table" style="width: 80%; text-align: center;">
						<tr>
						<c:if test="${currentPage>1}">
						<td><a class="btn btn-light" href="${pageContext.request.contextPath}/auth/FilmListServlet?currentPage=1"> << </a></td>
						<td><a class="btn btn-light" href="${pageContext.request.contextPath}/auth/FilmListServlet?currentPage=${currentPage-1}"> < </a></td>
						</c:if>
						
						<c:if test="${currentPage==1 }">
							<td class=" text-secondary"style="font-size: 20px"> << </td>
							<td class=" text-secondary"style="font-size: 20px"> < </td>
						</c:if>
						<c:forEach var="sp" begin="${firstShow}" end="${lastShow}">
							<c:if test="${sp<=lastPage }">
								<c:if test="${sp!=currentPage}">
								<td><a class="btn btn-light" href="${pageContext.request.contextPath}/auth/FilmListServlet?currentPage=${sp}">${sp}</a></td>
								</c:if>
								<c:if test="${sp==currentPage}">
								<td class=" text-secondary"style="font-size: 20px">${sp}</td>
								</c:if>
							</c:if>
					
						</c:forEach>
						<c:if test="${currentPage<lastPage}">
						<td><a class="btn btn-light" href="${pageContext.request.contextPath}/auth/FilmListServlet?currentPage=${currentPage+1}"> > </a></td>
						<td><a class="btn btn-light" href="${pageContext.request.contextPath}/auth/FilmListServlet?currentPage=${lastPage}"> >> </a></td>
						</c:if>
						
							<c:if test="${currentPage==lastPage }">
						<td class=" text-secondary"style="font-size: 20px"> > </td>
						<td class=" text-secondary"style="font-size: 20px"> >> </td>
						</c:if>
					</tr>
					
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>