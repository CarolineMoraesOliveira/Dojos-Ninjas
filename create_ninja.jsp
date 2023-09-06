<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
<h1>New ninja</h1>
<form:form action = "/ninjas " method = "post" modelAttribute ="ninja">
	
	
	<form:label path="firstName">First Name:</form:label>
	<form:errors path ="firstName"></form:errors>
	<form:input type = "text" path="firstName"/>
	
	<form:label path="lastName">Last Name:</form:label>
	<form:errors path ="lastName"></form:errors>
	<form:input type = "text" path="lastName"/>
	
	<form:label path="age">Age:</form:label>
	<form:errors path ="age"></form:errors>
	<form:input type = "number" path="age"/>
	
	<form:label path="dojo">Dojo:</form:label>
	<form:select path ="dojo">
		<c:forEach var = "oneDojo" items = "${dojos}">
			<form:option path = "dojo" value = "${oneDojo.id}"><c:out value="${oneDojo.name}"/></form:option> 
		</c:forEach>
	</form:select>
	
	
	
	<input type ="submit" value = "Create">
	
</form:form>
	
</body>
</html>