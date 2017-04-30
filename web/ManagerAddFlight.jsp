<%--
  Created by IntelliJ IDEA.
  User: ReedS
  Date: 4/30/2017
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String accountText = "";
    if(session.getAttribute("role").toString().equals("MANAGER")){
        accountText = session.getAttribute("userEmail").toString();
    } else {
        response.sendRedirect("logout.jsp");
    }

%>

<html>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/manager.css">
    <title>Add Flight</title>
</head>

<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/manager.css">
    <title>Managers</title>
</head>
<header>

    <a href="index.jsp" id="logo">
        <h1>Iowa Air</h1>
        <h2>Travel Like A Hawkeye</h2>
    </a>
    <nav>
        <ul>
            <li>
                <div class="account-dropdown">
                    <a href="manager.jsp">
                        <button class="account-dropbutton">Checkin</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="ManagerUserLookup.jsp">
                        <button class="account-dropbutton">User Lookup</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="ManagerSearchFlight.jsp">
                        <button class="account-dropbutton">Flight Search</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="ManagerCancelFlight.jsp">
                        <button class="account-dropbutton">Cancel Flight</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="manager.jsp">
                        <button class="account-dropbutton selected"><%=accountText%>
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

<body>


<br>

</body>
</html>
