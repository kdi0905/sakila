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
				
					<span class="index">영화 배우 관리</span>
					<hr style="min-width:800px; height: 2px;" class="hr">
						<a class="btn btn-secondary" style="float: left" href="">신규 배우	등록</a>
				<div style="float: right">
					<form method="post" action="">
					<input type="text" placeholder="배우 이름 검색" style="width:300px; height:40px;">
					<button type="button" id="btn" class="btn btn-secondary" >검색</button>
					</form>
					</div>
					
					<div style="margin-top: 40px">
					<table class="table" style="width: 800px; text-align: center;">
						<thead>
							<tr>
								<th>번호</th>
								<th>배우 성</th>
								<th>배우 이름</th>				
							</tr>
						</thead>
						<tbody >
								
					 </tbody>
					</table>
					</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>