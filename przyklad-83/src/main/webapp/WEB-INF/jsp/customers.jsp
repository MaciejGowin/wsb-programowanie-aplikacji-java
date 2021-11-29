<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<body>
<%@include file="menu.jsp" %>

<h2>Customers</h2>

<p>
    Sort by:
    <a href="${contextPath}/customers">None</a>
    <a href="${contextPath}/customers?sortBy=id">Id</a>
    <a href="${contextPath}/customers?sortBy=firstName">First name</a>
    <a href="${contextPath}/customers?sortBy=lastName">Last name</a>
</p>

<c:forEach items="${customers}" var="customer">
    <p><a href="${contextPath}/customers/${customer.id}">Customer ${customer.id}:</a> ${customer.firstName} ${customer.lastName}</p>
</c:forEach>

</body>

</html>
