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
</style>
<nav nav class="navbar menuBg ">
	<ul class="navbar-nav">

		<li>
			<table class="table table-borderless">
				<tr>
					<td colspan="2" class="text-center"><a
						class="text-dark moviePx " href="/sakila/auth/IndexServlet">Sakila
							Movie</a></td>
				</tr>
				<tr>
					<td rowspan="2"><img width="80px" height="80px"
						src="${pageContext.request.contextPath }/images/login.PNG">
					</td>
					<td class="text-right">서울지점</td>
				</tr>
				<tr>
					<td><span>${loginStaff.username} </span>관리자님</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
					<a class="btn btn-dark"	style="width: 200px"
						href="${pageContext.request.contextPath}/auth/LogoutServlet">Log-out</a>
					</td>
				</tr>
			</table>

			<table></table>

		</li>

	</ul>
	<!-- ${pageContext.request.contextPath} //현재 위치 에 있는 파일 -->


</nav>