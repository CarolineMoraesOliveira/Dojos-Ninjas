<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
<h1>New Dojo</h1>
<form:form action ="/dojos/create" method ="post" modelAttribute ="dojo">
	<form:label path="name">Name:</form:label>
	<form:errors path ="name"></form:errors>
	<form:input type = "text" path="name"/>
	<input type ="submit" value = "Create">
	
</form:form>
	
</body>
</html>