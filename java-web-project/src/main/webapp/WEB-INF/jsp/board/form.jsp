<%@ 
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 글</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>
  <jsp:include page="../header.jsp" />
  <div class="container">
  <h1>새 글</h1>
  <form action='add' method='post'>
    <table border='1'>
      <tr>
        <th>내용</th>
        <td><textarea name='contents' rows='5' cols='50'></textarea></td>
      </tr>
    </table>
    <p>
      <button type='submit' class="btn btn-primary btn-sm">등록</button>
      <a href='.' class="btn btn-primary btn-sm">목록</a>
    </p>
  </form>
  </div>
  
  <jsp:include page="../javascript.jsp" />
</body>
</html>
