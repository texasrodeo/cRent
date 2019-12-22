<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<tg:base>
    <h2>AutoPark</h2>
        <table class="table table-striped">
            <tr><th>Brand</th><th>Info</th><th>Price</th><th>Availability</th></tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td> ${car.getBrand()}</td>
                    <td> ${car.getInfo()}</td>
                    <td> ${car.getPrice()}</td>
                    <td> ${car.getIsAvailable()}</td>

                    <td>
                        <a href="${pageContext.request.contextPath}/car?id=${car.getId()}" class="btn btn-primary">Show </a>
                    </td>
                    <td>
                        <c:if test = "${car.getIsAvailable()}">
                            <a href="${pageContext.request.contextPath}/car/sendRequest?id=${car.getId()}" class="btn btn-primary">Send rent request</a>
                        </c:if>
                    </td>

                </tr>
            </c:forEach>
        </table>
</tg:base>
</body>

