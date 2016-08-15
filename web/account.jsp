<%@ page import="com.vahtakiss.classes.utils.DBConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.vahtakiss.classes.Beverage" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h1>Ваши заказы</h1>
<%
    String uid = "";
    Cookie cookies[] = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getValue() == "uid") uid = cookie.getValue();
    }

    List<Beverage> listBeverages = null;
    try {
        listBeverages = DBConnection.getInstance().getUsualOrders(uid);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    for (Beverage beverage : listBeverages) {

%>
<form action="">
    <input type="text" name="coffee<%--<%=beverage;%>--%>" value="">
    <input type="number" name="sugar" value="">
    <input type="checkbox" name="milk" value="">
    <input type="checkbox" name="nuts" value="">
    <input type="checkbox" name="syrup" value="">
    <input type="checkbox" name="zephyr" value="">

    <%}%>
</form>
</body>
</html>
