<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>사진 검색</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>

<body>

  <jsp:include page="../header.jsp" />
   <div class="container">
   
  <h1>사진 검색 결과</h1>
	  <p>
	   <a href='form' class="btn btn-primary btn-sm">새 사진</a> 
	   <a href='../../' class="btn btn-primary btn-sm">메인화면</a>
	  </p>
    
  <table class="table table-hover">
	  <thead>
	     <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">등록일</th>
	      <th scope="col">조회수</th>
	      <th scope="col">수업</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${boards}" var="board">
	      <tr>
	        <th scope="row">${board.no}</td>
	        <td><a href='${board.no}'>${board.title}</a></td>
	        <td>${board.createdDate}</td>
	        <td>${board.viewCount}</td>
	        <td>${board.lessonNo}</td>
	      </tr>
	    </c:forEach>
	  </tbody>
  </table>
  
  <p>
    <a href='.' class="btn btn-primary btn-sm">목록</a>
  </p>
  
  </div>
  <jsp:include page="../javascript.jsp" />
  
</body>
</html>
