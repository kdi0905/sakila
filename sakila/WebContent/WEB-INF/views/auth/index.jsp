<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.index {
	font-size: 50px;
}

.hr {
	background-color: #A6A6A6
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="row-3">
				<jsp:include page="/WEB-INF/views/auth/inc/menu.jsp"></jsp:include>
			</div>

			<div style="min-width:800px; margin-top: 70px; margin-left: 30px">
				<div class="row-9">
					<span class="index">Index</span>
					<hr style="height: 2px;" class="hr">
					<span>sakila비디오 대여점 프로젝트</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>