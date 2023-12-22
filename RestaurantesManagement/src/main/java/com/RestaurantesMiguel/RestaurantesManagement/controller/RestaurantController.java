package com.RestaurantesMiguel.RestaurantesManagement.controller;
import com.RestaurantesMiguel.RestaurantesManagement.model.Order.RestaurantOrder;
import com.RestaurantesMiguel.RestaurantesManagement.model.Order.OrderRequest;
import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import com.RestaurantesMiguel.RestaurantesManagement.service.OrderService;
import com.RestaurantesMiguel.RestaurantesManagement.service.RestaurantService;
import com.RestaurantesMiguel.RestaurantesManagement.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private TableService tableService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestaurantService restaurantService;

    // Endpoint to find and assign an available table
    @GetMapping("/tables/assign")
    public ResponseEntity<?> assignAvailableTable() {
        RestaurantTable restaurantTable = restaurantService.findAndAssignAvailableTable();
        if (restaurantTable != null) {
            return ResponseEntity.ok(restaurantTable);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No available tables.");
        }
    }



    // Endpoint to get menu items
    @GetMapping("/menu")
    public ResponseEntity<List<MenuItem>> getMenuItems() {
        List<MenuItem> menuItems = restaurantService.getMenuItems();
        return ResponseEntity.ok(menuItems);
    }
    @PostMapping("/tables/updateGuests")
    public ResponseEntity<?> updateTableGuests(@RequestParam("tableId") Long tableId, @RequestParam("numberOfGuests") int numberOfGuests) {
        try {
            RestaurantTable updatedTable = restaurantService.updateTableGuests(tableId, numberOfGuests);
            return ResponseEntity.ok(updatedTable);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating table guests");
        }
    }


    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        RestaurantTable restaurantTable = restaurantService.getTableById(orderRequest.getTableId());
        if (restaurantTable == null) {
            return ResponseEntity.badRequest().body("Invalid table ID");
        }

        RestaurantOrder restaurantOrder = restaurantService.processOrder(restaurantTable, orderRequest.getMenuItemIds());
        return ResponseEntity.ok(restaurantOrder);
    }
    @GetMapping("/tables/availableTable")
    public RestaurantTable getAvailableTable() {
        return tableService.findAvailableTable();
    }
}

