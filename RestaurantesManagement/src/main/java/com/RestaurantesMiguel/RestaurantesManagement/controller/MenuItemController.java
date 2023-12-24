package com.RestaurantesMiguel.RestaurantesManagement.controller;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import com.RestaurantesMiguel.RestaurantesManagement.service.MenuItemService;
import com.RestaurantesMiguel.RestaurantesManagement.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurant/menu-items")
public class MenuItemController {


    public String index(){
        return index();
    }
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/{id}")
    public MenuItem getMenuItem(@PathVariable Long id) {
        return menuItemService.getMenuItem(id);
    }

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenuItem(menuItem);
    }
}

