<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<tg:base>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${car.getBrand()}</h5>
            <p class="card-text">${car.getInfo()}</p>
            <p class="card-text">${car.getPrice()}</p>
            <a href="${pageContext.request.contextPath}/autopark" class="btn btn-secondary">Back</a>
        </div>
    </div>
</tg:base>
</body>
