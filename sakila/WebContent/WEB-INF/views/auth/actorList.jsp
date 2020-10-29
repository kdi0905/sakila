<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
              padding:0;
              margin:0;

              width: 1300px; //가로 폭
              height: 100%; // 세로폭
              overflow: hidden; // 범위를 넘엇을시 넘는 영역 숨김
              background-position: 0 0; // 시작위치
              background-repeat: no-repeat; // 배경화면 반복
              background-attachment: fixed; // 배경화면 스크롤시 고정
              background-size: cover; // 배경화면 비율유지
              position: relative; // 위치지정
              overflow-y: auto; //스크롤
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
				
					<span class="index">영화 배우 관리</span>
					<hr style="min-width:800px; height: 2px;" class="hr">
					
				
			</div>
		</div>
	</div>
</body>
</html>