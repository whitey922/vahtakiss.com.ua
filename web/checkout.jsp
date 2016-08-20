<%@ page import="com.vahtakiss.classes.Supplements" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" href="css/main.css"/>
    <script src="js/addorder.js">

    </script>
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
            <input id="hostel_number" name="hostel" type="text">
            <input id="room_number" name="room" type="text">
            <input id="submit" type="submit" value="Send" onclick="clearLocalStorage()">
            <input type="button" value="Remove" onclick="clearLocalStorage()">
        </form>
    </div>
</div>

</body>
<%--Create orders from localstorage--%>
<script>
    $(document).ready(function () {
        GetOrders();
    });
    function GetOrders() {

        $("#orderList tbody").empty();//Clear all table nodes

        $("#orderList tbody").append(
                "<tr>" + "" +
                "<td>" + "<input type='hidden' name='count' value=" + JSON.parse(localStorage.getItem("orders")).length + ">" + "</td>" +
                "</tr>");

        var count = 0;
        for (var i in orders) {
            var ord = JSON.parse(orders[i]);
            var TR = document.createElement("TR");
            TD_REMOVE = document.createElement('TD');
            REMOVE = document.createElement('SPAN');
            REMOVE.setAttribute('class', 'btnDelete')
            REMOVE.id = i;
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
            if (ord.milk) MILK.setAttribute("checked", "checked");
            TD_MILK.appendChild(MILK);
            TR.appendChild(TD_MILK);

            TD_NUTS = document.createElement("TD");
            NUTS = document.createElement('INPUT');
            NUTS.type = 'checkbox';
            NUTS.name = 'nuts' + count;
            NUTS.id = 'nuts' + count;
            if (ord.nuts) NUTS.setAttribute("checked", "checked");
            TD_NUTS.appendChild(NUTS);
            TR.appendChild(TD_NUTS);

            TD_ZEPHYR = document.createElement("TD");
            ZEPHYR = document.createElement('INPUT');
            ZEPHYR.type = 'checkbox';
            ZEPHYR.name = 'zephyr' + count;
            ZEPHYR.id = 'zephyr' + count;
            if (ord.zephyr) ZEPHYR.setAttribute("checked", "checked");
            TD_ZEPHYR.appendChild(ZEPHYR);
            TR.appendChild(TD_ZEPHYR);

            appendSyrups('<%=Supplements.NO_SYRUP%>');
            appendSyrups('<%=Supplements.SYRUP_WITH_COCONUT%>');
            appendSyrups('<%=Supplements.SYRUP_WITH_CHOCOLATE%>');
            appendSyrups('<%=Supplements.SYRUP_WITH_RASPBERRY%>');
            appendSyrups('<%=Supplements.SYRUP_WITH_CARAMEL%>');
            appendSyrups('<%=Supplements.SYRUP_WITH_MINT%>');

            function appendSyrups(syrup) {
                TD_SYRUP = document.createElement("TD");
                SYRUP = document.createElement('INPUT');
                DESC_SYRUP = document.createElement('SPAN');
                DESC_SYRUP.innerText = syrup;
                SYRUP.type = 'radio';
                SYRUP.name = 'syrup' + count;
                SYRUP.id = 'syrup' + count;
                if (syrup == ord.syrup) SYRUP.setAttribute("checked", "checked");
                TD_SYRUP.appendChild(DESC_SYRUP);
                TD_SYRUP.appendChild(SYRUP);
                TR.appendChild(TD_SYRUP);
            }

            TBODY = document.getElementById('orderList').firstElementChild;
            TBODY.appendChild(TR);
            count++;
        }
    }

    function RemoveOrder() {
        orders.splice(selected_index, 1);
        localStorage.setItem("orders", JSON.stringify(orders));
        GetOrders();
    }
    $(document).on("click", ".btnDelete", function (e) {
        selected_index = parseInt($(this).attr("ID"));
        RemoveOrder();
    });
</script>
</html>
