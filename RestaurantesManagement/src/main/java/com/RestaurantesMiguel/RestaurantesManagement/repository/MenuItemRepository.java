package com.RestaurantesMiguel.RestaurantesManagement.repository;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("SELECT mi FROM MenuItem mi WHERE mi.category = :category")
    List<MenuItem> findMenuItemsByCategory(String category);

    @Query("SELECT mi FROM MenuItem mi WHERE mi.price BETWEEN :minPrice AND :maxPrice")
    List<MenuItem> findMenuItemsByPriceRange(double minPrice, double maxPrice);

    // Add more custom queries as needed
}
