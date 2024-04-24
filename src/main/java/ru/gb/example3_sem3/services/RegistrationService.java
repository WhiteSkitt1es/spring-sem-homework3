package ru.gb.example3_sem3.services;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem3.domain.User;

@Service
public class RegistrationService {


    private DataProcessingService dataProcessingService;

    private UserService userService;

    private NotificationService notificationService;

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Поля UserService, NotificationService
    //Метод processRegistration


    public void processRegistration(String name, int age, String email) {
        // По условиям задачи реализовать метод , через параметры , использовать notificationService
        // но он у нас реализуется же при вызове метода createUser
//       User user = new User();
//       user.setName(name);
//       user.setAge(age);
//       user.setEmail(email);
//       notificationService.notifyUser(user);
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);

    }
}
