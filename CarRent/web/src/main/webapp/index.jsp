<%@ page contentType="text/html" language="java" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<tg:base>
    <h2>Welcome to car rent website</h2>
    <br>
    <a href="${pageContext.request.contextPath}/autopark">Show cars</a>
    <br>
    <a href="${pageContext.request.contextPath}/contracts">Show contracts</a>
</tg:base>
