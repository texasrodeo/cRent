<%@ page contentType="text/html" language="java" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>



<head>
    <meta name="viewport" content=" initial-scale=4">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>

<tg:base>
    <h2>Welcome to car rent website</h2>
    <br>
    <a href="${pageContext.request.contextPath}/autopark" class="btn btn-primary">Show cars</a>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/autopark" class="btn btn-primary">Show contracts</a>

</tg:base>
