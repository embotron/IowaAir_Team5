<%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 3/26/2017
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a href="index.jsp">
                        <button class="account-dropbutton">Search</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="contact.jsp">
                        <button class="account-dropbutton">Contact Us</button>
                    </a>
                </div>
            </li>

            <li>
                <div class="account-dropdown">
                    <a href="myAccount.jsp">
                        <button class="account-dropbutton selected">My Account</button>
                    </a>
                    <div class="account-dropdown-content">
                        <a href="login.jsp">Log In</a>
                        <a href="activeFlights.jsp" class="selected">Active Flights</a>
                        <a href="flightHistory.jsp">Flight History</a>
                        <a href="payment.jsp">Payment Info</a>
                    </div>
                </div>
            </li>
        </ul>
    </nav>
</header>


<div id="viewwrapper">

    <section id="sidebar">
        <p>
            Active
        </p>



    </section>


    <section id="main">
        <p>
            Flights
        </p>
    </section>

</div>

<footer>

</footer>

</body>

</html>