<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.menuBg {
	background-color: #D5D5D5
}

.moviePx {
	font-size: 40px
}
.hr{
	background-color: #A6A6A6
}
</style>
<nav class="navbar menuBg ">
	<ul class="navbar-nav">
		<li>
			<table class="table table-borderless" style="margin-bottom: 80px;">
				<tr>
					<td colspan="2" class="text-center"><a
						class="text-dark moviePx " href="/sakila/auth/IndexServlet">Sakila
							Movie</a></td>
				</tr>
				<tr>
					<td rowspan="2"><a href=""><img width="80px" height="80px"
						src="${pageContext.request.contextPath }/images/login.PNG"></a>
					</td>
					<td class="text-right">서울지점</td>
				</tr>
				<tr>
					<td class="text-right"><span>${loginStaff.username} </span>관리자님</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center"><a class="btn btn-dark"
						style="width: 200px"
						href="${pageContext.request.contextPath}/auth/LogoutServlet">Log-out</a>
					</td>
				</tr>
			</table>
		<li>
			<table class="table table-borderless" style="margin-bottom: 150px;">
				<tr>
					<td><h2 class="text-dark">Menu</h2></td>
				</tr>
				<tr>
					<td><a class ="text-dark"
						href="${pageContext.request.contextPath}/auth/IndexServlet">홈</a></td>
				</tr>
				<tr>
					<td>
						<a class ="text-dark" href="">영화 반납</a>
						<hr style="height:2px;"class="hr">
						<div class="nav flex-column">
						<a class ="text-dark" href="">회원목록 관리</a>
						<a class ="text-dark" href="">영화목록 관리</a>
						<a class ="text-dark" href="">영화재고 관리</a>
						<a class ="text-dark" href="">영화배우 관리</a>
						<a class ="text-dark" href="">영화 출연 배우 등록 관리</a>
						</div>
						<hr style="height:2px;"class="hr">
						<div class="nav flex-column">
						<a class ="text-dark" href="">매장통계</a>
						<a class ="text-dark" href="">MVP</a>
						</div>
					</td>
					
				</tr>
			</table>
		</li>
	</ul>
	<!-- ${pageContext.request.contextPath} //현재 위치 에 있는 파일 -->
</nav>