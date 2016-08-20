var selected_index = -1; //Index of the selected list item
var orders = localStorage.getItem("orders");//Retrieve the stored data
orders = JSON.parse(orders); //Converts string to object
if (orders == null) {
    orders = [];
}
function Add(coffee) {
    var client = JSON.stringify({
        coffee: coffee,
        sugar: $('input[name=sugar]',  '.'+coffee+'_order').val(),
        milk: $('input[name=milk]:checked',  '.'+coffee+'_order').val(),
        nuts: $('input[name=nuts]:checked', '.'+coffee+'_order').val(),
        zephyr: $('input[name=zephyr]:checked', '.'+coffee+'_order').val(),
        syrup: $('input[name=syrup]:checked', '.'+coffee+'_order').val(),

    });
    orders.push(client);
    localStorage.setItem("orders", JSON.stringify(orders));
    alert("Order was successful!")
    return true;
}
