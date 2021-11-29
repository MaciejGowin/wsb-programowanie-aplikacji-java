<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<body>
<%@include file="menu.jsp" %>

<h2>Customer ${customer.id}</h2>
<p>${customer.firstName} ${customer.lastName}</p>
</body>

</html>
