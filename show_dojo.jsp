<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
</head>
<body>
<h1><c:out value ="${dojo.name}"/></h1>	
	
<ul>
	<c:forEach var="ninja" items="${dojo.ninjas}">
		<li><c:out value="${ninja.firstName}"/>
			<c:out value="${ninja.lastName}"/><br>
			<c:out value="${ninja.age}"/>
		</li>
	</c:forEach>
</ul>
</body>
</html>