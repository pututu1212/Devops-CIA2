package com.college.devopscia;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void homeEndpointReturnsExpectedMessage() {
        String response = restTemplate.getForObject(
            "http://localhost:" + port + "/", String.class);
        assertEquals("DevOps CIA 2 - CI/CD Pipeline is running!", response);
    }

    @Test
    void healthEndpointReturnsUp() {
        String response = restTemplate.getForObject(
            "http://localhost:" + port + "/health", String.class);
        assertEquals("UP", response);
    }
}
