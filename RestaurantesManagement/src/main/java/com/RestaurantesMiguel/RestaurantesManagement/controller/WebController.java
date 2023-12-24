package com.RestaurantesMiguel.RestaurantesManagement.controller;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WebController {

    @GetMapping("/test")
    public String index() {

        return "index"; // Assuming you have an index.html in the static or public folder
    }
}
