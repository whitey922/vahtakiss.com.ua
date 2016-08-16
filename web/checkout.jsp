<%@ page import="com.vahtakiss.classes.Supplements" %><%--
  Created by IntelliJ IDEA.
  User: Yegorov
  Date: 04.08.2016
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" href="css/main.css"/>

</head>
<body>
<div class="container">
    <div class="row">
        <h1>Корзина</h1>
        <form action="Test" method="POST">
            <table id="orderList">
                <tbody>

                </tbody>
            </table>
            <textarea name="description" id="description" cols="30" rows="10"></textarea>
            <input id="submit" type="submit" value="Send" onclick="clearLocalStorage()">
            <input type="button" value="Remove" onclick="clearLocalStorage()">
        </form>
    </div>
</div>

</body>
<script>
    $(document).ready(function () {
        getOrderList();
    });

    function getOrderList() {
        /*clear all orders to */
        $("#orderList tbody").empty();
        /*Get list objects from localstorage and put it into form to send it to server*/

        $("#orderList tbody").append(
                "<tr>" + "" +
                "<td>" + "<input type='hidden' name='count' value=" + localStorage.length + ">" + "</td>" +
                "</tr>");
        var count = 0;
        for (var i in localStorage) {
            var ord = JSON.parse(localStorage[i]);

/*            var TR = document.createElement("TR");

            TD_REMOVE = document.createElement('TD');
            REMOVE = document.createElement('SPAN');
            REMOVE.addEventListener("click", function () {
                removeOrder(i);
            });
            REMOVE.innerText = 'remove';
            TD_REMOVE.appendChild(REMOVE);
            TR.appendChild(TD_REMOVE);

            TD_COFFEE = document.createElement('TD');
            COFFEE = document.createElement('INPUT');
//            COFFEE.type = 'hidden';
            COFFEE.value = ord.coffee;
            COFFEE.name = 'coffee' + count;
            COFFEE.id = 'coffee' + count;
            COFFEE.innerHTML = ord.coffee;
            TD_COFFEE.appendChild(COFFEE);
            TR.appendChild(TD_COFFEE);

            TD_SUGAR = document.createElement('TD');
            SUGAR = document.createElement('INPUT');
            SUGAR.type = 'number';
            SUGAR.max = '4';
            SUGAR.min = '0';
            SUGAR.value = ord.sugar;
            SUGAR.name = 'sugar' + count;
            SUGAR.id = 'sugar' + count;
            TD_SUGAR.appendChild(SUGAR);
            TR.appendChild(TD_SUGAR);

            TD_MILK = document.createElement('TD');
            MILK = document.createElement('INPUT');
            MILK.type = 'checkbox';
            MILK.name = 'milk' + count;
            MILK.id = 'milk' + count;
            TD_MILK.appendChild(MILK);
            TR.appendChild(TD_MILK);

            TD_NUTS = document.createElement("TD");
            NUTS = document.createElement('INPUT');
            NUTS.type = 'checkbox';
            NUTS.name = 'nuts' + count;
            NUTS.id = 'nuts' + count;
            TD_NUTS.appendChild(NUTS);
            TR.appendChild(TD_NUTS);

            TD_ZEPHYR = document.createElement("TD");
            ZEPHYR = document.createElement('INPUT');
            ZEPHYR.type = 'checkbox';
            ZEPHYR.name = 'zephyr' + count;
            ZEPHYR.id = 'zephyr' + count;
            TD_ZEPHYR.appendChild(ZEPHYR);
            TR.appendChild(TD_ZEPHYR);

            TD_SYRUP = document.createElement("TD");
            SYRUP = document.createElement('INPUT');
            SYRUP.type = 'checkbox';
            SYRUP.name = 'syrup' + count;
            SYRUP.id = 'syrup' + count;
            TD_SYRUP.appendChild(SYRUP);
            TR.appendChild(TD_SYRUP);


            TBODY = document.getElementById('orderList').firstElementChild;
            TBODY.appendChild(TR);*/


            $("#orderList tbody").append(
                    "<tr>" + "" +
                    "<td>" + "<span onclick='removeOrder(" + i + ")' >удалить<span></td>" +
                    "<td>" + "<input type='hidden' name=" + "coffee" + count + " value=" + ord.coffee + " id=" + "coffee" + count + ">" + ord.coffee + "</td>" +
                    "<td>" + "<input type='number' min='0' max='4' name=" + "sugar" + count + " value=" + ord.sugar + " id=" + "sugar" + count + ">" + "</td>" +
                    "<td>" + "Milk: " + "<input id=" + "milk" + count + " type='checkbox' name=" + "milk" + count + ">" + "</td>" +
                    "<td>" + "Nuts: " + "<input id=" + "nuts" + count + " type='checkbox' name=" + "nuts" + count + ">" + "</td>" +
                    "<td>" + "Zephyr: " + "<input id=" + "zephyr" + count + " type='checkbox' name=" + "zephyr" + count + ">" + "</td>" +
                    "<td>" + "Syrup: " +
                    "<select id=" + "syrup" + count + " name=" + "syrup" + count + "selected=''>"+
                    "<option value='<%=Supplements.SYRUP_WITH_COCONUT %>'> <%=Supplements.SYRUP_WITH_COCONUT.getDescription()%> </option>"+
                    "<option value='<%=Supplements.SYRUP_WITH_CHOCOLATE %>'> <%=Supplements.SYRUP_WITH_CHOCOLATE.getDescription()%> </option>"+
                    "<option value='<%=Supplements.SYRUP_WITH_RASPBERRY %>'> <%=Supplements.SYRUP_WITH_RASPBERRY.getDescription()%> </option>"+
                    "<option value='<%=Supplements.SYRUP_WITH_CARAMEL %>'> <%=Supplements.SYRUP_WITH_CARAMEL.getDescription()%> </option>"+
                    "<option value='<%=Supplements.SYRUP_WITH_MINT %>'> <%=Supplements.SYRUP_WITH_MINT.getDescription()%> </option>"+
                    "<option value='<%=Supplements.NO_SYRUP %>'> <%=Supplements.NO_SYRUP.getDescription()%> </option>"+
                    "</select>"+"</td>" +
                    "</tr>");
            count++;
        }

    }

    function clearLocalStorage() {
        localStorage.clear();
    }

    function removeOrder(order) {
        localStorage.removeItem(order)
        getOrderList();
//
//        if($("#orderList tbody").empty()) {
//            $("#submit").remove();
//        }
    }
</script>

<script>
    $(document).ready(function () {
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
    });
</script>

</html>
