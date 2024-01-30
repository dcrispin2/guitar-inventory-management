package dcrispin.iu.c322spring2024homework2.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// ./mvnw spring-boot:run
@RestController
public class HomeController {
    @GetMapping("/")
    public String greetings()
    {
        return "Welcome to Guitar Inventory Management!";
    }
}