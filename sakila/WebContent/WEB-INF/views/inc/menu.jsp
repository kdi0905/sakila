<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<ul>
		<li><a href="/sakila/auth/IndexServlet">Sakila Movie</a></li>
		<li><span>${loginStaff.username} </span>관리자님</li>
		<li><a href="${pageContext.request.contextPath}/auth/LogoutServlet">Log-out</a>
	</ul>
<!-- ${pageContext.request.contextPath} //현재 위치 에 있는 파일 -->


</nav>