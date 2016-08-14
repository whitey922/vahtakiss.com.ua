<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 03.08.2016
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static java.awt.SystemColor.text" %>
<%@ page import="com.vahtakiss.classes.Beverages" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css"/>
    <title>VahtaKiss</title>
    <script>
        function toLocal(coffee) {
            var orderObject = {
                'coffee':   document.getElementById(coffee + "_title").innerHTML,
                'sugar':    document.getElementById(coffee + "_sugar").value,
                'milk':     document.getElementById(coffee + "_milk").checked,
                'nuts':     document.getElementById(coffee + "_nuts").checked,
                'syrup':    document.getElementById(coffee + "_syrup").checked,
                'zephyr':   document.getElementById(coffee + "_zephyr").checked
            };
            localStorage.setItem(Math.floor(Math.random() * (1000000 - 0) + 0), JSON.stringify(orderObject));
        }
    </script>

    <script type="text/javascript" src="//vk.com/js/api/openapi.js?125"></script>
    <script type="text/javascript">
        VK.init({apiId: 5282019});
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Авторизуйтесь</h1>
        <div class = "row">
            <div id="vk_auth"></div>
        </div>
    </div>

    <div class="row">
        <h1>Сделайте заказ</h1>
        <%! Beverages[] beverages = Beverages.values(); %>
        <% for (int i = 0; i < beverages.length; i++) { %>

        <form class="order">
            <h2 id="<%=getString(beverages[i], "title")%>">
                <%= beverages[i] %>
            </h2>

            <label for="sugar"> Sugar: </label>
            <input id="<%=getString(beverages[i], "sugar")%>" name="sugar" type="number" min="0" max="3" value="1"/>

            <label for="milk">Milk: </label>
            <input id="<%=getString(beverages[i], "milk")%>" name="milk" type="checkbox">

            <label for="nuts">Nuts: </label>
            <input id="<%=getString(beverages[i], "nuts")%>" name="nuts" type="checkbox">

            <label for="syrup">Syrup: </label>
            <input id="<%=getString(beverages[i], "syrup")%>" name="syrup" type="checkbox">

            <label for="zephyr">Zephyr: </label>
            <input id="<%=getString(beverages[i], "zephyr")%>" name="zephyr" type="checkbox">

            <input type="submit" value="Order" onclick="toLocal('<%= beverages[i] %>')"/>
        </form>

        <% } %>

        <a href="checkout.jsp">GO TO BAG</a>


        <%!
            String getString(Beverages coffeeType, String sufix) {
                String out = coffeeType + "_" + sufix;
                return out;
            }
        %>
    </div>
</div>
<script type="text/javascript">
    VK.Widgets.Auth("vk_auth", {redesign: 1, width: "200px", authUrl: '/VkAuth'});
</script>
</body>
</html>
