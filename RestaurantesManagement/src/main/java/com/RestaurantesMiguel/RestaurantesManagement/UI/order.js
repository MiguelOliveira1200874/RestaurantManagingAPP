document.getElementById("orderForm").addEventListener("submit", function(event) {
    event.preventDefault();
    let tableId = new URLSearchParams(window.location.search).get('tableId');
    let menuItemIds = []; // Collect menu item IDs from the form

    fetch('/restaurant/orders/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ tableId: tableId, menuItemIds: menuItemIds })
    })
        .then(response => response.json())
        .then(data => {
            console.log('Order placed:', data);
            // Handle successful order placement
        })
        .catch(error => console.error('Error:', error));
});
