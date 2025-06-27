package main.my_app;

import main.my_app.model.User;
import main.my_app.service.IUserDao;
import main.my_app.service.UserService;

import java.util.List;

public class MainService {

    private final IUserDao iUserDao;
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        // Создание пользователей
        User user1 = new User("user1");
        User user2 = new User("user2");
        userService.createUser(user1);
        userService.createUser(user2);

        // Получение всех пользователей
        List<User> users = userService.getAllUsers();
        System.out.println("All users: " + users);

        // Получение пользователя по ID
        User user = userService.getUserById(1L);
        System.out.println("User with ID 1: " + user);

        // Удаление пользователя
        userService.deleteUser(1L);

        // Получение всех пользователей после удаления
        users = userService.getAllUsers();
        System.out.println("All users after deletion: " + users);
    }

}
