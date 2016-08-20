<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.vahtakiss.classes.Beverages" %>
<%@ page import="com.vahtakiss.classes.Supplements" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <title>VahtaKiss</title>
    <script src="js/addorder.js"></script>
    <script type="text/javascript" src="//vk.com/js/api/openapi.js?125"></script>
    <script type="text/javascript">
        VK.init({apiId: 5282019});
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Авторизуйтесь</h1>
        <div class="row">
            <div id="vk_auth"></div>
        </div>
    </div>

    <div class="row">
        <h1>Сделайте заказ</h1>
        <%! Beverages[] beverages = Beverages.values(); %>
        <% for (int i = 0; i < beverages.length; i++) { %>

        <form class="<%= beverages[i] %>_order">
            <h2 id="<%=getString(beverages[i], "title")%>">
                <%= beverages[i] %>
            </h2>

            <% String sugar = getString(beverages[i], "sugar"); %>
            <label for="<%=sugar%>"> Sugar: </label>
            <input id="<%=sugar%>" name="sugar" type="number" min="0" max="3" value="1"/>

            <% String milk = getString(beverages[i], "milk"); %>
            <label for="<%=milk%>">Milk: </label>
            <input id="<%=milk%>" name="milk" type="checkbox">

            <% String nuts = getString(beverages[i], "nuts"); %>
            <label for="<%=nuts%>">Nuts: </label>
            <input id="<%=nuts%>" name="nuts" type="checkbox">

            <% String zephyr = getString(beverages[i], "zephyr"); %>
            <label for="<%=zephyr%>">Zephyr: </label>
            <input id="<%=zephyr%>" name="zephyr" type="checkbox">

            <% String syrup = getString(beverages[i], "syrup"); %>
            <label for="<%=syrup%>">Syrup: </label>
            <input type="radio" name="syrup"
                   value="<%=Supplements.NO_SYRUP %>"> <%=Supplements.NO_SYRUP.getDescription()%>
            <input type="radio" name="syrup"
                   value="<%=Supplements.SYRUP_WITH_COCONUT %>"> <%=Supplements.SYRUP_WITH_COCONUT.getDescription()%>
            <input type="radio" name="syrup"
                   value="<%=Supplements.SYRUP_WITH_CHOCOLATE %>"> <%=Supplements.SYRUP_WITH_CHOCOLATE.getDescription()%>
            <input type="radio" name="syrup"
                   value="<%=Supplements.SYRUP_WITH_RASPBERRY %>"> <%=Supplements.SYRUP_WITH_RASPBERRY.getDescription()%>
            <input type="radio" name="syrup"
                   value="<%=Supplements.SYRUP_WITH_CARAMEL %>"> <%=Supplements.SYRUP_WITH_CARAMEL.getDescription()%>
            <input type="radio" name="syrup"
                   value="<%=Supplements.SYRUP_WITH_MINT %>"> <%=Supplements.SYRUP_WITH_MINT.getDescription()%>
            <input type="button" value="Order" onclick="Add('<%= beverages[i] %>')"/>
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
