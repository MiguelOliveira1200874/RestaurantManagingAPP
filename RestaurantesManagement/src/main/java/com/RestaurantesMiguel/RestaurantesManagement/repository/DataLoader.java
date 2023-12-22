package com.RestaurantesMiguel.RestaurantesManagement.repository;
import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final TableRepository tableRepository;

    public DataLoader(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        RestaurantTable restaurantTable1 = new RestaurantTable();
// Set properties for table1
// e.g., table1.setPropertyName(value);

        RestaurantTable restaurantTable2 = new RestaurantTable();
// Set properties for table2
// e.g., table2.setPropertyName(value);

    }
}
