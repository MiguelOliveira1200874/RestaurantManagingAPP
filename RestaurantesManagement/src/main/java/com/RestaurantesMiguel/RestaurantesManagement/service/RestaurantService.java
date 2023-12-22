package com.RestaurantesMiguel.RestaurantesManagement.service;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import com.RestaurantesMiguel.RestaurantesManagement.model.Order.RestaurantOrder;
import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import com.RestaurantesMiguel.RestaurantesManagement.repository.MenuItemRepository;
import com.RestaurantesMiguel.RestaurantesManagement.repository.OrderRepository;
import com.RestaurantesMiguel.RestaurantesManagement.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class RestaurantService {

    // Assuming Autowired repositories exist
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private OrderRepository orderRepository;



        // Example methods based on your existing codebase

        // Method to find and assign an available table
        public RestaurantTable findAndAssignAvailableTable() {
        RestaurantTable availableRestaurantTable = tableRepository.findTopByIsOccupiedFalse();
        if (availableRestaurantTable != null) {
            availableRestaurantTable.setOccupied(true);
            tableRepository.save(availableRestaurantTable);
        }
        return availableRestaurantTable;
    }
        // Method to get menu items
        public List<MenuItem> getMenuItems() {
            // Retrieve all menu items
            return menuItemRepository.findAll();
        }

    public RestaurantTable updateTableGuests(Long tableId, int capacity) {
        RestaurantTable table = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        table.setCapacity(capacity);
        return tableRepository.save(table);
    }
    public RestaurantTable getTableById(Long tableId) {
        // Assuming you have a method in your TableRepository to find a table by its ID
        return tableRepository.findById(tableId).orElse(null);
    }

        // Method to process an order
        public RestaurantOrder processOrder(RestaurantTable restaurantTable, List<Long> menuItemIds) {
            List<MenuItem> selectedItems = menuItemRepository.findAllById(menuItemIds);
            RestaurantOrder newRestaurantOrder = new RestaurantOrder(restaurantTable, selectedItems, LocalDateTime.now(), RestaurantOrder.OrderStatus.PENDING);
            return orderRepository.save(newRestaurantOrder);
        }

        // Additional logic and helper methods based on your project's specifics
    }


