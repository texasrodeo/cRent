
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add contract</title>
    <meta name="viewport" content="width=device-width, initial-scale=4">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <h1>Add contract</h1>

    <form style="width:300px" method="post">
        <div class="form-group">
            <label for="start">Start</label>
            <input type="date" class="form-control" id="start" name="start" >
        </div>
        <div class="form-group">
            <label for="end">End</label>
            <input type="date" class="form-control" id="end" name="end" >
        </div>



        <button type="submit" class="btn btn-default">Send</button>
    </form>

</div>
</body>
</html>
