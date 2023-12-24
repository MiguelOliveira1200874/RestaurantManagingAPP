document.addEventListener('DOMContentLoaded', () => {
    fetchMenuItems();
});

function fetchMenuItems() {
    fetch('http://localhost:8080/restaurant/menu') // Adjust the endpoint as necessary
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(menuItems => {
            const menuContainer = document.getElementById('menuItems');
            menuContainer.innerHTML = ''; // Clear out any existing content
            menuItems.forEach(item => {
                const itemElement = document.createElement('div');
                itemElement.classList.add('menu-item');
                itemElement.innerHTML = `
                    <h3>${item.name}</h3>
                    <p>${item.description}</p>
                    <p><b>Price:</b> $${item.price}</p>
                    <p><b>Category:</b> ${item.category}</p>
                `;
                menuContainer.appendChild(itemElement);
            });
        })
        .catch(error => {
            console.error('Error fetching menu items:', error);
        });
}
