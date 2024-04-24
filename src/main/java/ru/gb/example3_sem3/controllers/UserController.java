package ru.gb.example3_sem3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3.domain.User;
import ru.gb.example3_sem3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;



    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {

        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }


    @GetMapping("/creat")
    public String userAddFromParam(@RequestParam String name,@RequestParam int age, @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User added ";
    }
}
