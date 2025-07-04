package user.runner;

import org.springframework.context.annotation.ComponentScan;
import user.context.DataSourceConfig;
import user.model.User;
import user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StartContext {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);

        UserService userService = context.getBean(UserService.class);

        demoCrudOperations(userService);
    }

    private static void demoCrudOperations(UserService userService) {
        System.out.println("\n== Начало демонстрационных операций CRUD ==\n");

        // Создаем нового пользователя
        User newUser = new User(null, "Иван Иванов");
        int createdRows = userService.createUser(newUser);
        System.out.printf("Пользователь '%s' создан (%d строки).\n", newUser.getUsername(), createdRows);

        // Читаем всех пользователей
        System.out.println("\nВсе пользователи:");
        userService.getAllUsers().forEach(System.out::println);

        // Обновляем имя пользователя
        newUser.setUsername("Василий Васильев");
        int updatedRows = userService.updateUser(newUser);
        System.out.printf("\nПользователь '%s' обновлен (%d строки).\n", newUser.getUsername(), updatedRows);

        // Повторно читаем всех пользователей
        System.out.println("\nОбновленные пользователи:");
        userService.getAllUsers().forEach(System.out::println);

        // Убираем первого пользователя (по умолчанию возьмем первый элемент)
        User firstUser = userService.getAllUsers().stream().findFirst().orElseThrow(() -> new RuntimeException("Нет пользователей"));
        int deletedRows = userService.deleteUser(firstUser.getId());
        System.out.printf("\nУдалено %d пользователей.\n", deletedRows);

        // Еще раз выводим список пользователей
        System.out.println("\nФинальный список пользователей:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("\n== Конец демонстрации операций CRUD ==");
    }
}

