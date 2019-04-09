<%@page import="com.eomcs.lms.domain.Member"%>
<%@ 
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%
    Member loginUser = (Member) session.getAttribute("loginUser");
%>
<header>
<img src='http://bitcamp.co.kr/img/logo.jpg' style='height:50px'>
<%if(loginUser == null) {%>
<a href='${contextPath}/auth/login'>로그인</a>
<%} else { %>
<img src='${contextPath}/upload/member/${loginUser.photo}' 
     style='height:20px'>${loginUser.name}
<a href='${contextPath}/auth/logout'>로그아웃</a>
<%}%>
</header>