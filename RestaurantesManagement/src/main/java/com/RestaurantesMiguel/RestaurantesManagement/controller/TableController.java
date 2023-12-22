package com.RestaurantesMiguel.RestaurantesManagement.controller;

import com.RestaurantesMiguel.RestaurantesManagement.service.TableService;
import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public ResponseEntity<List<Table>> getAllTables() {
        return ResponseEntity.ok((List<Table>) tableService.getAllTables());
    }

    @PostMapping("/{tableId}/occupy")
    public ResponseEntity<Void> occupyTable(@PathVariable Long tableId) {
        tableService.occupyTable(tableId);
        return ResponseEntity.ok().build();
    }

    // Additional endpoints for releasing a table, updating dishes, etc.
}

