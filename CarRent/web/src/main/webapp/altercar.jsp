<%--
  Created by IntelliJ IDEA.
  User: rakdo
  Date: 23.12.2019
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change car</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <h1>Alter car</h1>

    <form style="width:300px" method="post">
        <input type="hidden" name="id" value="">
        <div class="form-group">
            <label for="brand">Car brand</label>
            <input type="text" class="form-control" id="brand" name="brand" placeholder="brand">
        </div>
        <div class="form-group">
            <label for="info">Car info</label>
            <input type="text" class="form-control" id="info" name="info" placeholder="info">
        </div>
        <div class="form-group">
            <label for="price">Car price</label>
            <input type="text" class="form-control" id="price" name="price" placeholder="price">
        </div>
        <div class="form-group">
            <label for="availability">Car avaliability</label>
            <input type="checkbox" class="form-control" id="availability" name="availability" placeholder="price">
        </div>


        <button type="submit" class="btn btn-default">Add</button>
    </form>

</div>
</body>
</html>
