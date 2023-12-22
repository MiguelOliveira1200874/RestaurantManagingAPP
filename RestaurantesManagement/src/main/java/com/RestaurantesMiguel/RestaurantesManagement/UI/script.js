// script.js
document.querySelectorAll('.table').forEach(table => {
    table.addEventListener('click', function() {
        this.classList.toggle('occupied');
        // Update the dishes section based on selected table
        updateDishesSection(this.id);
    });
});

function updateDishesSection(tableId) {
    // Example: Update dishes based on selected table
    // This should be replaced with actual logic to fetch dishes
    const dishesSection = document.getElementById('selected-table-dishes');
    dishesSection.innerHTML = `Dishes for ${tableId}: <br> Dish 1, Dish 2, ...`;
}
