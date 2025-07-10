package user.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user.model.User;
import user.service.UserService;

@RequiredArgsConstructor
@Component
public class StartContextRunner implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n== Начало демонстрационных операций CRUD ==\n");
        System.out.println("Создание юзера");
        User newUser = new User(null, "Иван Иванов");
        User createdUser = userService.createUser(newUser);
        System.out.printf("Пользователь '%s' создан.\n", createdUser);

        System.out.println("Получение всех юзеров");
        System.out.println("\nВсе пользователи:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("Обновление");
        newUser.setUsername("Василий Васильев");
        User updatedUser = userService.updateUser(newUser);
        System.out.printf("\nПользователь '%s' обновлен.\n", updatedUser);

        System.out.println("Проверка обновления");
        System.out.println("\nОбновленные пользователи:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("Удаляем первую запись");
        User firstUser = userService.getAllUsers().stream().findFirst().orElseThrow(() -> new RuntimeException("Нет пользователей"));
        userService.deleteUser(firstUser);
        System.out.printf("\nУдален %s пользователm.\n", firstUser);

        System.out.println("Проверка удаления");
        System.out.println("\nФинальный список пользователей:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("\n== Конец демонстрации операций CRUD ==");
    }
}