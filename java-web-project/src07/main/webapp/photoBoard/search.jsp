<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>

<html>
<head>
<title>사진 검색</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <h1>사진 검색 결과(JSP2 + EL)</h1>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>등록일</th>
      <th>조회수</th>
      <th>수업</th>
    </tr>
    <jsp:useBean scope="request" id="boards" type="java.util.List<PhotoBoard>" />
    <%
      for (PhotoBoard board : boards) {
        pageContext.setAttribute("board", board);
    %>
    <tr>
      <td>${board.no}</td>
      <td><a href='detail?no=${board.no}'>${board.title}</a></td>
      <td>${board.createdDate}</td>
      <td>${board.viewCount}</td>
      <td>${board.lessonNo}</td>
    </tr>
    <%
      }
    %>
  </table>
  <p>
    <a href='list'>목록</a>
  </p>
</body>
</html>
