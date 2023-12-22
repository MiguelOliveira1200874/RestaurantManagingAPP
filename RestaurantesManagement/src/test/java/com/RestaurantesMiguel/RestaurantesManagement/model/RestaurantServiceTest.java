package com.RestaurantesMiguel.RestaurantesManagement.model;

import com.RestaurantesMiguel.RestaurantesManagement.model.Order.RestaurantOrder;
import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import com.RestaurantesMiguel.RestaurantesManagement.repository.MenuItemRepository;
import com.RestaurantesMiguel.RestaurantesManagement.repository.OrderRepository;
import com.RestaurantesMiguel.RestaurantesManagement.repository.TableRepository;
import com.RestaurantesMiguel.RestaurantesManagement.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Mock
    private TableRepository tableRepository;

    @InjectMocks
    private RestaurantService restaurantService;
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private MenuItemRepository menuItemRepository;


    @Test
    public void testFindAndAssignAvailableTable() {
        RestaurantTable mockRestaurantTable = new RestaurantTable(); // Assuming a default constructor
        mockRestaurantTable.setOccupied(false);

        when(tableRepository.findTopByIsOccupiedFalse()).thenReturn(mockRestaurantTable);

        RestaurantTable assignedRestaurantTable = restaurantService.findAndAssignAvailableTable();
        assertNotNull(assignedRestaurantTable, "No table was assigned");
        assertTrue(assignedRestaurantTable.isOccupied(), "Assigned table should be marked as occupied");
    }



    @Test
    public void testProcessOrder() {
        RestaurantTable restaurantTable = new RestaurantTable(); // Set properties as needed
        List<Long> menuItemIds = Arrays.asList(1L, 2L); // Example menu item IDs
        RestaurantOrder mockRestaurantOrder = new RestaurantOrder(); // Assuming a constructor or setters

        when(orderRepository.save(any(RestaurantOrder.class))).thenReturn(mockRestaurantOrder);

        RestaurantOrder restaurantOrder = restaurantService.processOrder(restaurantTable, menuItemIds);
        assertNotNull(restaurantOrder, "Order should not be null");
        // Additional assertions as necessary
    }
}
