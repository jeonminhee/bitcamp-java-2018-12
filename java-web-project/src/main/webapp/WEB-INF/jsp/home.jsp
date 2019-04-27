<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

<jsp:include page="header.jsp" />

  <div class="jumbotron">
  <h1 class="display-4">JAVA WEB PROJECT</h1>
  <p class="lead">수업 관리 시스템</p>
  <hr class="my-4">
  <p>이 화면은 2018년 12월 개강 반 프로젝트이다.</p>
</div>
  
<jsp:include page="javascript.jsp"/>

</body>
</html>