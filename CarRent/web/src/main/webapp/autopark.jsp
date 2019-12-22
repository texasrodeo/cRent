<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<head>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">--%>

<%--    <link href="/WEB-INF/css/leftside.css" rel="stylesheet" type="text/css">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>


<tg:base>


<%--    <div class="wrapper">--%>
<%--        <!-- Sidebar -->--%>
<%--        <nav id="sidebar">--%>
<%--            <div class="sidebar-header">--%>
<%--                <h3>Bootstrap Sidebar</h3>--%>
<%--            </div>--%>

<%--            <ul class="list-unstyled components">--%>
<%--                <p>Dummy Heading</p>--%>
<%--                <li class="active">--%>
<%--                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Home</a>--%>
<%--                    <ul class="collapse list-unstyled" id="homeSubmenu">--%>
<%--                        <li>--%>
<%--                            <a href="#">Home 1</a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#">Home 2</a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#">Home 3</a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="#">About</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Pages</a>--%>
<%--                    <ul class="collapse list-unstyled" id="pageSubmenu">--%>
<%--                        <li>--%>
<%--                            <a href="#">Page 1</a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#">Page 2</a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#">Page 3</a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="#">Portfolio</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="#">Contact</a>--%>
<%--                </li>--%>
<%--            </ul>--%>

<%--        </nav>--%>
<%--        <!-- Page Content -->--%>
<%--        <div id="content">--%>

<%--            <nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--                <div class="container-fluid">--%>

<%--                    <button type="button" id="sidebarCollapse" class="btn btn-info">--%>
<%--                        <i class="fas fa-align-left"></i>--%>
<%--                        <span>Toggle Sidebar</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </nav>--%>
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
        <br>
        <a href="${pageContext.request.contextPath}/addcar" class="btn btn-primary">Add car</a>
<%--        </div>--%>
<%--    </div>--%>






</tg:base>

<%--<!-- jQuery CDN - Slim version (=without AJAX) -->--%>
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
<%--<!-- Popper.JS -->--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>--%>
<%--<!-- Bootstrap JS -->--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>--%>
<%--<!-- jQuery Custom Scroller CDN -->--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>--%>

<%--<script>--%>
<%--    $(document).ready(function () {--%>

<%--        $("#sidebar").mCustomScrollbar({--%>
<%--            theme: "minimal"--%>
<%--        });--%>

<%--        $('#sidebarCollapse').on('click', function () {--%>
<%--            $('#sidebar').toggleClass('active');--%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>

<%--<script>--%>
<%--    $(document).ready(function () {--%>

<%--        $("#sidebar").mCustomScrollbar({--%>
<%--            theme: "minimal"--%>
<%--        });--%>

<%--        $('#sidebarCollapse').on('click', function () {--%>
<%--            // open or close navbar--%>
<%--            $('#sidebar').toggleClass('active');--%>
<%--            // close dropdowns--%>
<%--            $('.collapse.in').toggleClass('in');--%>
<%--            // and also adjust aria-expanded attributes we use for the open/closed arrows--%>
<%--            // in our CSS--%>
<%--            $('a[aria-expanded=true]').attr('aria-expanded', 'false');--%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>

</body>

