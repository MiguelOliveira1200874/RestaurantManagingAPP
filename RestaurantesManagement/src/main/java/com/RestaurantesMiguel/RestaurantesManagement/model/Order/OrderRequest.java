package com.RestaurantesMiguel.RestaurantesManagement.model.Order;

import java.util.List;

public class OrderRequest {

    private Long tableId;
    private List<Long> menuItemIds;

    // Constructors, getters, and setters
    public OrderRequest() {}

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public List<Long> getMenuItemIds() {
        return menuItemIds;
    }

    public void setMenuItemIds(List<Long> menuItemIds) {
        this.menuItemIds = menuItemIds;
    }
}
