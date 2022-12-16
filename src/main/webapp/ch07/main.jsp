<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--include: 페이지를 삽입함과 동시에 값을 넘겨줄 수 있다--%>
	<jsp:include page="header.jsp">
		<jsp:param value="My home" name="title"/>
	</jsp:include>
</body>
</html>