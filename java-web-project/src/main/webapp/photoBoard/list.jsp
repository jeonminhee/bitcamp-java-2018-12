<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@page import="java.util.List"%>
<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>

<%
  List<PhotoBoard> list = (List<PhotoBoard>) request.getAttribute("list");
%>

<html>
<head>
<title>사진 목록</title>
</head>
<body>
 <jsp:include page="/header.jsp"/>
  <h1>사진 목록(JSP)</h1>
  <p>
    <a href='add'>새 사진</a>
  </p>
  <p>
    <a href='../'>메인화면</a>
  </p>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>등록일</th>
      <th>조회수</th>
      <th>수업</th>
    </tr>
    <%for(PhotoBoard board : list) {%>
    <tr>
      <td><%=board.getNo()%></td>
      <td><a href='detail?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
      <td><%=board.getCreatedDate()%></td>
      <td><%=board.getViewCount()%></td>
      <td><%=board.getLessonNo()%></td>
    </tr>
    <%}%>
  </table>
  <form action='search' method='get'>
    수업번호: <input type='text' name='lessonNo'> 검색어: <input type='text' name='keyword'>
    <button type='submit'>검색</button>
  </form>
</body>
</html>

