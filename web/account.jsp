<%@ page import="com.vahtakiss.classes.utils.DBConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.vahtakiss.classes.basement.Beverage" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.vahtakiss.classes.utils.Parser" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Ваши заказы</h1>
        <form action="EditUsualOrder" class="order">
            <%
                String uid = "";
                Cookie cookies[] = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getValue() == "uid") uid = cookie.getValue();
                }

                HashMap<String, Beverage> beveragesMap = null;
                try {
                    beveragesMap = DBConnection.getInstance().getUsualOrders("23338953");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                Set<Map.Entry<String, Beverage>> beverageSet = beveragesMap.entrySet();
                for (Map.Entry<String, Beverage> elem : beverageSet) {
                    HashMap<String, String> beverageMap = Parser.beverageToMap(elem.getValue());
            %>

            <input type="text" name="coffee<%=elem.getKey()%>" value="<%=beverageMap.get("coffee")%>">
            <input type="number" name="sugar<%=elem.getKey()%>" value="<%=beverageMap.get("sugar")%>">
            <input type="checkbox" name="milk<%=elem.getKey()%>" <%=beverageMap.get("milk")%>>
            <input type="checkbox" name="nuts<%=elem.getKey()%>" <%=beverageMap.get("nuts")%>>
            <input type="checkbox" name="syrup<%=elem.getKey()%>" <%=beverageMap.get("syrup")%>>
            <input type="checkbox" name="zephyr<%=elem.getKey()%>" <%=beverageMap.get("zephyr")%>>

            <%}%>
            <input type="submit" value="SAVE CHANGES">
        </form>
    </div>
</div>
</body>
</html>
