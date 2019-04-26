<%@ 
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 회원</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>

<body>
<jsp:include page="../header.jsp"/>
<div class="container">
<h1>새 회원</h1>
<form action='add' method='post' enctype='multipart/form-data'>

 <div class="form-group">
    <label for="name">이름</label>
    <input type="text" name="name" class="form-control" id="name" placeholder="이름을 적으세요.">
 </div>
 
 <div class="row">
    <div class="col">
      <input type="email" class="form-control" name="email" placeholder="이메일을 적으세요.">
    </div>
    <div class="col">
      <input type="password" class="form-control" name="password" placeholder="암호를 적으세요.">
    </div>
</div>

<div class="form-group">
  <input type="file" id="photoFile" name="photoFile">
</div>              

<div class="form-group">
    <label for="tel">전화</label>
    <input type="text" name="tel" class="form-control" id="tel" placeholder="전화번호를 적으세요.">
</div>


<p>
  <button class="btn btn-outline-primary" type='submit'>등록</button>
  <a class="btn btn-outline-primary" href='.'>목록</a>
</p>
</form>
</div>
<jsp:include page="../javascript.jsp" />
</body>
</html>
