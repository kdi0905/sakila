<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<nav nav class="navbar bg-light">
	<ul class="navbar-nav">
		<li><a href="/sakila/auth/IndexServlet">Sakila Movie</a><br></li>
		<li><img width="50px" height="50px" src="${pageContext.request.contextPath }/images/login.PNG"><span>${loginStaff.username} </span>관리자님</li>
		<li><a href="${pageContext.request.contextPath}/auth/LogoutServlet">Log-out</a>
	</ul>
<!-- ${pageContext.request.contextPath} //현재 위치 에 있는 파일 -->


</nav>