package com.RestaurantesMiguel.RestaurantesManagement;

import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import com.RestaurantesMiguel.RestaurantesManagement.repository.TableRepository;
import com.RestaurantesMiguel.RestaurantesManagement.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class RestaurantServiceTest {

    @MockBean
    private TableRepository tableRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void updateTableGuestsTest() {
        // Arrange
        RestaurantTable table = new RestaurantTable();
        table.setId(1L);
        when(tableRepository.findById(1L)).thenReturn(Optional.of(table));

        // Act
        RestaurantTable updatedTable = restaurantService.updateTableGuests(1L, 4);

        // Assert
        assertEquals("Number of guests should match", 4, updatedTable.getCapacity());

        verify(tableRepository).save(any(RestaurantTable.class));
    }
}

