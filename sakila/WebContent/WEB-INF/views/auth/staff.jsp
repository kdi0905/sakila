<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	padding: 0;
	margin: 0;
	width: 1300px; 
	height : 100%; 
	overflow: hidden;
	background-position : 0 0;
	background-repeat: no-repeat; 
	background-attachment :fixed;
	background-size : cover;
	position :relative; 
	overflow-y: auto;
}

.index {
	font-size: 40px;
}

.hr {
	background-color: #A6A6A6;
}

.imgBg {
	background-color: #D5D5D5;
	width: 200px;
	height: 250px;
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			
				<jsp:include page="/WEB-INF/views/auth/inc/menu.jsp"></jsp:include>
			
			<div style="margin-top: 70px; margin-left: 30px">

				<span class="index">관리자 정보</span> 
				<a class="btn btn-secondary" style="margin-top: 25px; width: 100px; height: 35px; float: right;"
					href="">정보수정</a>
				<hr style="min-width: 800px; height: 2px;" class="hr">

				<div class="col">
					<table class="table table-borderless" style="width: 300px; float: left;">
						<tr>
							<td>별명</td>
							<td>${username}</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${firstName}&nbsp;${lastName}</td>
						</tr>
						<tr>
							<td>연락처</td>
							<td>${phone }</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>${address }</td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td>${email }</td>
						</tr>
					</table>
				</div>
				<div class="col">
					<div class="imgBg" style="float: right;">
						<img width="150px" height="200px" src="${pageContext.request.contextPath}/images/${picture}">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>