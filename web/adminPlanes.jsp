<%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 3/26/2017
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="AirFunctions.AdminFunctions" %>
<%
    String accountText = "";
    if(session.getAttribute("role").toString().equals("admin")){
        accountText = session.getAttribute("userEmail").toString();
    } else {
        response.sendRedirect("logout.jsp");
    }

%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Iowa Air</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/responsive.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<header>
    <a href="index.jsp" id="logo">
        <h1>Iowa Air</h1>
        <h2>Travel Like A Hawkeye</h2>
    </a>
    <nav>
        <ul>
            <li>
                <div class="account-dropdown">
                    <a href="adminLocations.jsp">
                        <button class="account-dropbutton">Locations</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="adminPlanes.jsp">
                        <button class="account-dropbutton selected">Planes</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="adminFlights.jsp">
                        <button class="account-dropbutton">Flights</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="adminManagers.jsp">
                        <button class="account-dropbutton">Managers</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="admin.jsp">
                        <button class="account-dropbutton"><%=accountText%>
                        </button>
                    </a>
                    <div class="account-dropdown-content">
                        <a href="logout.jsp">Log Out</a>
                    </div>
                </div>
            </li>
        </ul>
    </nav>
</header>

<div id="adminPlanes">
    <h1>Planes</h1>
    <form action="AirFunctions.AdminFunctions">
        Plane Type <input type="text" name="planeType" placeholder="Type" required>
        Plane Capacity <input type="email" name="planeCapacity" placeholder="Capacity" required>
        Number of Classes <input type="email" name="planeClasses" placeholder="Classes" required>
        <button type="submit" name="addPlaneButton">Add Flight</button>
    </form>
    <%=AdminFunctions.getPlanes()%>
</div>

<footer>

</footer>

</body>

</html>