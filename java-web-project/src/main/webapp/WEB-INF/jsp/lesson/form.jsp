<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<html>
<head>
<title>새 수업</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>
	<jsp:include page="../header.jsp" />

	<div class="container">
		<h1>새 수업</h1>
		<form action='add' method='post'>

			<div class="form-group">
				<label for="title">수업</label> <input type="text"
					class="form-control" id="title" name="title">
			</div>

			<div class="form-group">
				<label for="contents">내용</label>
				<textarea class="form-control" id="contents" name="contents"
					rows="3"></textarea>
			</div>

			<div class="form-group">
				<label for="startDate">시작일</label> <input type="date"
					class="form-control" id="startDate" name="startDate">
			</div>

			<div class="form-group">
				<label for="endDate">종료일</label> <input type="date"
					class="form-control" id="endDate" name="endDate">
			</div>

			<div class="row">
			
				<div class="col">
					<label for="totalHours">총 교육시간</label> 
					<input type="number" class="form-control" id="totalHours" name="totalHours">
				</div>
				
				<div class="col">
					<label for="totalHours">일 교육시간</label> 
					<input type="number" class="form-control" id="dayHours" name="dayHours">
				</div>
				
			</div>

      <p>
      <div class="form-group row">
        <div class="col-sm-10">
          <button class="btn btn-primary btn-sm">등록</button>
          <a href='.' class="btn btn-primary btn-sm">목록</a> 
        </div>
      </div>
      </p>
		</form>
	</div>

	<jsp:include page="../javascript.jsp" />
	 
</body>
</html>
