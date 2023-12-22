package com.RestaurantesMiguel.RestaurantesManagement.repository;

import com.RestaurantesMiguel.RestaurantesManagement.model.Order.RestaurantOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<RestaurantOrder, Long> {

    @Query("SELECT o FROM RestaurantOrder o WHERE o.table.id = :tableId")
    List<RestaurantOrder> findOrdersByTableId(Long tableId);



    @Query("SELECT o FROM RestaurantOrder o WHERE o.orderTime BETWEEN :startTime AND :endTime")
    List<RestaurantOrder> findOrdersInTimeRange(LocalDateTime startTime, LocalDateTime endTime);

    // Add more custom queries as needed
}
