
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <h1>Add car</h1>

    <form style="width:300px" method="post">
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


        <button type="submit" class="btn btn-default">Add</button>
    </form>

</div>
</body>
</html>
