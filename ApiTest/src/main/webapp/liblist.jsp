<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/lib01.js"></script>
</head>
<body>
	<form action="lib.do" method="post">
		<input type="submit" value="db에 저장">
		<input type="hidden" name="command" value="listdb">
		<table>
			<thead></thead>
			<tbody></tbody>
		</table>
	</form>
</body>
</html>