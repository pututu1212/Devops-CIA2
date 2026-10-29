package com.college.devopscia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    static class StatusController {
        @GetMapping("/")
        public String home() {
            return "DevOps CIA 2 - CI/CD Pipeline is running!";
        }

        @GetMapping("/health")
        public String health() {
            return "UP";
        }
    }
}
