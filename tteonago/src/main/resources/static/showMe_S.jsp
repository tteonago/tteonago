<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
	   <h1>로그인 상태가 아닙니다!</h1>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
	   <h1>로그인 상태 입니다!</h1>
	</sec:authorize>
</body>
</html>