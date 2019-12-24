<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=4">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>


<tg:base>

    <h2>Contracts</h2>

    <table class="table table-striped">
        <tr><th>Id</th><th>Created at</th><th>Ends at</th><th>Client id</th><th>Car id</th><th>Approved</th></tr>
        <c:forEach items="${contracts}" var="contract">
            <tr>
                <td>${contract.getId()}</td>
                <td>${contract.getCreatedAt()}</td>
                <td> ${contract.getEndsAt()}</td>
                <td> ${contract.getClientID()}</td>
                <td> ${contract.getCarId()}</td>
                <td> ${contract.getIsApproved()}</td>


                <td>
                    <c:if test = "${contract.getIsApproved() == false}">
                        <a href="${pageContext.request.contextPath}/approvecontract?id=${contract.getId()}" class="btn btn-primary">Approve</a>
                    </c:if>
                </td>


            </tr>
        </c:forEach>
    </table>
    <br>








</tg:base>



</body>

