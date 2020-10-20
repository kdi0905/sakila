<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {
		$("#btn").click(function() {
			if ($("#id").val() == "ID") {
				alert("아이디를 입력해주세요");
				return;
			} else if ($("pw").val() == "PW") {
				alert("비밀번호를 입력해주세요");
				return;
			}
			$("#loginForm").submit();
		});
	});
</script>
</head>
<body>
	<div class="container ">

		<div class ="text-right">오늘 접속자 수 : ${stats.cnt}</div>
		<div class ="text-right">총 접속자 수 : ${totalCount}</div>
		<form method="post" id="loginForm" action="">
			<table class="table table-borderless text-center ">
				<tr>
					<td><img class="rounded-circle" width="400px" height="200px" src="./images/login.PNG"></td>
				</tr>
				<tr>
					<td><input type="text" id="ID" placeholder="ID" ></td>
				</tr>
				<tr>
					<td><input type="password" id="ID" placeholder="PW" ></td>
				</tr>
				<tr>
					<td>
						<button type="button" id="btn" class="btn btn-secondary">로그인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>