package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.model.User;
import user.repository.UserRepository;


import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public User createUser(User user) {
        if (user.getUsername().isEmpty()) throw new IllegalArgumentException("Имя пользователя не должно быть пустым!");
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

    public User updateUser(User updatedUser) {
        return userRepository.save(updatedUser);
    }

    public boolean deleteUser(User user) {
        userRepository.delete(user);
        return true;
    }
}
