<%--
  Created by IntelliJ IDEA.
  User: Yegorov
  Date: 04.08.2016
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<html>
<head>
    <title>Корзина</title>
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel = "stylesheet" href = "css/main.css"/>

</head>
<body>
<div class = "container">
    <div class = "row">
        <h1>Корзина</h1>
        <form action = "Test" method = "POST">
            <table id = "orderList">
                <tbody>

                </tbody>
            </table>
            <input type = "submit" value = "Send" onclick="clearLocalStorage()">
            <input type = "button" value = "Remove" onclick = "clearLocalStorage()">
        </form>
    </div>
</div>

</body>
<script>
    /*Get list objects from localstorage and put it into form to send it to server*/
    $("#orderList tbody").append(
            "<tr>" + "" +
            "<td>" + "<input type='hidden' name='count' value=" + localStorage.length + ">" + "</td>" +
            "</tr>");
    var count = 0;
    for (var i in localStorage) {
        var ord = JSON.parse(localStorage[i]);
        $("#orderList tbody").append(
                "<tr>" + "" +
                "<td>" + "<input type='hidden' name=" + "coffee" + count + " value=" + ord.coffee + " id=" + "coffee" + count + ">" + ord.coffee + "</td>" +
                "<td>" + "<input type='number' min='0' max='2' name=" + "sugar" + count + " value=" + ord.sugar + " id=" + "sugar" + count + ">" + "</td>" +
                "<td>" + "Milk: " + "<input id=" + "milk" + count + " type='checkbox' name=" + "milk" + count + ">" + "</td>" +
                "<td>" + "Nuts: " + "<input id=" + "nuts" + count + " type='checkbox' name=" + "nuts" + count + ">" + "</td>" +
                "<td>" + "Syrup: " + "<input id=" + "syrup" + count + " type='checkbox' name=" + "syrup" + count + ">" + "</td>" +
                "<td>" + "Zephyr: " + "<input id=" + "zephyr" + count + " type='checkbox' name=" + "zephyr" + count + ">" + "</td>" +
                "</tr>");
        count++;
    }

    function clearLocalStorage() {
        localStorage.clear();
    }

    function createInputs() {
        
    }
</script>

<script>
    var count = 0;
    for (var i in localStorage) {
        var ord = JSON.parse(localStorage[i]);

        if (ord.milk)
            $("#milk" + count).prop('checked', true);

        if (ord.nuts)
            $("#nuts" + count).prop('checked', true);

        if (ord.syrup)
            $("#syrup" + count).prop('checked', true);

        if (ord.zephyr)
            $("#zephyr" + count).prop('checked', true);

        count++;
    }

</script>
</html>
