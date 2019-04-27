<%@page import="com.eomcs.lms.domain.PhotoFile"%>
<%@page import="java.util.List"%>
<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>사진 조회</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

  <jsp:include page="../header.jsp" />
  <div class="container">
  
  <h1>사진 조회</h1>
  
  <c:choose>
    <c:when test="${empty board}">
      <p>해당 사진을 찾을 수 없습니다.</p>
      <meta http-equiv="refresh" content="2;url=list">
    </c:when>
    
    <c:otherwise>
      <form action='update' method='post' enctype='multipart/form-data'>
      
        <div class="form-group">
			    <label for="no">번호</label>
			    <input name='no' value='${board.no}' readonly class="form-control">
			  </div>

        <div class="form-group">    
			    <label for="title">제목</label>
			    <input type="text" name='title' value='${board.title}' class="form-control">
			  </div>
        
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="createdDate">등록일</label>
			      <input type="date" readonly class="form-control" value="${board.createdDate}">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="viewCount">조회수</label>
			      <input type="text" readonly class="form-control" value="${board.viewCount}">
			   </div>   
			  </div>
       
       
		   <div class="form-group">
		    <label for="lessonNo">수업</label>
		    <select class="form-control" id="lessonNo" name='lessonNo'>
		      <option selected="selected" value="${lesson.no}">"${lesson.no}"</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
		   </div>
		   
          
       <label>최소 한 개의 사진 파일을 등록해야 합니다.</label>
          
          <tr>
            <th>사진1</th>
            <td><input type='file' name='photo'></td>
          </tr>
          
          <tr>
            <th>사진2</th>
            <td><input type='file' name='photo'></td>
          </tr>
          
          <tr>
            <th>사진3</th>
            <td><input type='file' name='photo'></td>
          </tr>
          
          <tr>
            <th>사진4</th>
            <td><input type='file' name='photo'></td>
          </tr>
          
          <tr>
            <th>사진5</th>
            <td><input type='file' name='photo'></td>
          </tr>
          
          <tr>
            <th>사진</th>
            <c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
            <td><c:forEach items="${board.files}" var="file">
                <img src='${contextRootPath}/upload/photoboard/${file.filePath}' style='height: 80px'>
              </c:forEach></td>
          </tr>

        <p>
          <a href='.'>목록</a> <a href='delete/${board.no}'>삭제</a>
          <button type='submit'>변경</button>
        <p>
        
      </form>
    </c:otherwise>
    
  </c:choose>
  
  </div>
  <jsp:include page="../javascript.jsp"/>
</body>
</html>

