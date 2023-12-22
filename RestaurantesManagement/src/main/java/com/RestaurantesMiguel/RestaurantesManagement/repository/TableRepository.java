package com.RestaurantesMiguel.RestaurantesManagement.repository;

import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<RestaurantTable, Long> {

    @Query("SELECT t FROM RestaurantTable t WHERE t.isOccupied = :isOccupied")
    List<RestaurantTable> findTablesByOccupancyStatus(boolean isOccupied);


    // This method will find the first table which is not occupied
    // Custom method to find the first unoccupied table
    RestaurantTable findTopByIsOccupiedFalse();
    // Add more custom queries as needed
}
