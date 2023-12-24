package com.RestaurantesMiguel.RestaurantesManagement.service;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import com.RestaurantesMiguel.RestaurantesManagement.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository repository;

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }

    public MenuItem getMenuItem(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MenuItem createMenuItem(MenuItem item) {
        return repository.save(item);
    }

    // Add more methods as needed
}
