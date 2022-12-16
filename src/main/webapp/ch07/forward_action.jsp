<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>

	<jsp:include page="page_control_end.jsp">
		<jsp:param value="000-1111-2222" name="tel" />
	</jsp:include>
</body>
</html>