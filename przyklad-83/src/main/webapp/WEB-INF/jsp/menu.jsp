<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<a href="${contextPath}">All customers</a>
<a href="${contextPath}/newCustomer">New customer</a>
