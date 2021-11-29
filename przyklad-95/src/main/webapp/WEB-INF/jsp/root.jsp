<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<body>

<h1>Homepage</h1>

<div><a href="${pageContext.request.contextPath}/profile">My profile</a></div>

</body>
</html>
