package com.RestaurantesMiguel.RestaurantesManagement.service;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import com.RestaurantesMiguel.RestaurantesManagement.model.Order.RestaurantOrder;
import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import com.RestaurantesMiguel.RestaurantesManagement.repository.MenuItemRepository;
import com.RestaurantesMiguel.RestaurantesManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// OrderService.java
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantOrder processOrder(RestaurantTable restaurantTable, List<Long> menuItemIds) {
        List<MenuItem> selectedItems = menuItemRepository.findAllById(menuItemIds);
        RestaurantOrder newRestaurantOrder = new RestaurantOrder(restaurantTable, selectedItems, LocalDateTime.now(), RestaurantOrder.OrderStatus.PENDING);
        return orderRepository.save(newRestaurantOrder);
    }

}

