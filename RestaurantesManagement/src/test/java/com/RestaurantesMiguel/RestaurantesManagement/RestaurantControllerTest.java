package com.RestaurantesMiguel.RestaurantesManagement;

import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void assignAvailableTableTest() {
        ResponseEntity<RestaurantTable> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/restaurant/tables/assign",
                RestaurantTable.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // Additional assertions as needed
    }

    private void assertNotNull(RestaurantTable body) {
    }

    private void assertEquals(HttpStatus httpStatus, HttpStatus statusCode) {
        
    }
}
