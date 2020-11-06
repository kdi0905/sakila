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
				
					<span class="index">영화 반납</span>
					<hr style="min-width:800px; height: 2px;" class="hr">
					
				
			</div>
		</div>
	</div>
</body>
</html>